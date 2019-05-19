package com.crud.kodillalibrary.book;

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
@WebMvcTest(BookController.class)
public class BookControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookMapper bookMapper;

    @MockBean
    private BookService bookService;

    @Test
    public void addBook() throws Exception {
        //Given
        Book book = new Book(1L, "testTitle", "testAuthor", LocalDate.of(2010, 10, 10));
        BookDto bookDto = new BookDto(2L, "Title", "Author");

        when(bookService.addBook(bookMapper.mapToBook(bookDto))).thenReturn(book);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);

        //When & Then
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andExpect(status().isOk());
    }
}
