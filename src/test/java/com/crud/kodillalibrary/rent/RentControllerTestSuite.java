package com.crud.kodillalibrary.rent;

import com.crud.kodillalibrary.book.Book;
import com.crud.kodillalibrary.copy.Copy;
import com.crud.kodillalibrary.copy.Status;
import com.crud.kodillalibrary.reader.Reader;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RentController.class)
public class RentControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RentMapper rentMapper;

    @MockBean
    private RentService rentService;

    @Test
    public void testAddRent() throws Exception {
        //Given
        Book book = new Book("ja", "ty", LocalDate.of(2010, 12, 12));
        Copy copy = new Copy(book, Status.AVAILABLE);
        Reader reader = new Reader("jan", "janowy", LocalDate.of(1956, 6, 6));

        Rent rent = new Rent(LocalDate.of(2019, 4, 30), null, reader, copy);
        RentDto rentDto = new RentDto(1,1,1);

        when(rentService.addRent(rentMapper.mapToRent(rentDto))).thenReturn(rent);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(rentDto);

        //When & Then
        mockMvc.perform(post("/rents")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testReturnBook() throws Exception {
        //Given
        Long rentId = 1L;
        RentDto rentDto = new RentDto(1,1,1);

        when(rentMapper.mapToRentDto(rentService.returnBook(rentId))).thenReturn(rentDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(rentDto);

        //When & Then
        mockMvc.perform(patch("/rents/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.readerId", is(1)))
                .andExpect(jsonPath("$.copyId", is(1)));
    }

}