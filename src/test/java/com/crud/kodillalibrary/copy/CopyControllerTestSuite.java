package com.crud.kodillalibrary.copy;

import com.crud.kodillalibrary.book.Book;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CopyController.class)
public class CopyControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CopyMapper copyMapper;

    @MockBean
    private CopyService copyService;

    @Test
    public void testHowManyBooks() throws Exception {
        //Given
        Long bookId = 1L;
        long books = 2L;

        when(copyService.copiesAvailableToRent(bookId)).thenReturn(books);

        //WHen & Then
        mockMvc.perform(get("/copies/bookId/2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddCopy() throws Exception {
        //Given
        Book book = new Book("ja", "ty", LocalDate.of(2010, 12, 12));
        Copy copy = new Copy(book, Status.AVAILABLE);
        CopyDto copyDto = new CopyDto(1, 1, Status.AVAILABLE);

        when(copyService.addCopy(copyMapper.mapToCopy(copyDto))).thenReturn(copy);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(copyDto);

        //When & Then
        mockMvc.perform(post("/copies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testChangeStatus() throws Exception {
        //Given
        CopyDto copyDto = new CopyDto(1, 1, Status.AVAILABLE);

        when(copyMapper.mapToCopyDto(copyService.changeStatus(Status.DESTROYED, 10L))).thenReturn(copyDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(copyDto);

        //When & Then
        mockMvc.perform(patch("/copies/DESTROYED/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.bookId", is(1)))
                .andExpect(jsonPath("$.status", is("AVAILABLE")));
    }

}
