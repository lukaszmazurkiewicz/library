package com.crud.kodillalibrary.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTestSuite {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testGetBookById() {
        //Given
        Book book = new Book("testTitle", "testAuthor", LocalDate.of(2011, 10, 9));

        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book));

        //When
        Book testBook = bookService.getBookById(book.getId());

        //Then
        assertEquals(book.getId(), testBook.getId());
        assertEquals(book.getTitle(), testBook.getTitle());
        assertEquals(book.getAuthor(), testBook.getAuthor());
        assertEquals(book.getPublishDate(), testBook.getPublishDate());
    }

    @Test
    public void testAddBook() {
        //Given
        Book book = new Book("testTitle", "testAuthor", LocalDate.of(2011, 10, 9));
        Book book2 = new Book("testTitle2", "testAuthor2", LocalDate.of(2012, 12, 12));

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        //When
        Book testBook = bookService.addBook(book2);

        //Then
        assertEquals(book.getId(), testBook.getId());
        assertEquals(book.getTitle(), testBook.getTitle());
        assertEquals(book.getAuthor(), testBook.getAuthor());
        assertEquals(book.getPublishDate(), testBook.getPublishDate());
    }

}