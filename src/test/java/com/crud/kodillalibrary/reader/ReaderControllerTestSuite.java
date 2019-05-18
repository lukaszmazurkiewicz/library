package com.crud.kodillalibrary.reader;

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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReaderController.class)
public class ReaderControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReaderMapper readerMapper;

    @MockBean
    private ReaderService readerService;

    @Test
    public void testAddReader() throws Exception {
        //Given
        Reader reader = new Reader("jan", "janowy", LocalDate.of(1956, 6, 6));
        ReaderDto readerDto = new ReaderDto(1L, "jan", "janowy");

        when(readerService.addReader(readerMapper.mapToReader(readerDto))).thenReturn(reader);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(readerDto);

        //When & Then
        mockMvc.perform(post("/readers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}