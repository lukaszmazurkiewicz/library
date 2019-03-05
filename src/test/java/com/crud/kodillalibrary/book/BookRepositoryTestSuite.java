package com.crud.kodillalibrary.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTestSuite {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        long sizeOfDatabaseBeforeTest = bookRepository.count();

        Book book = new Book(1L, "abc", "def", LocalDate.of(1992,12,2));
        Book book2 = new Book(2L, "ghi", "jkl", LocalDate.of(2000, 2, 1));

        bookRepository.save(book);
        bookRepository.save(book2);

        //When
        List<Book> books = bookRepository.findAll();

        //Then
        assertEquals(2L, books.size() - sizeOfDatabaseBeforeTest);
        assertTrue(books.contains(book));
        assertTrue(books.contains(book2));
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Book book = new Book(1L, "abc", "def", LocalDate.of(1992,12,2));
        Book book2 = new Book(2L, "ghi", "jkl", LocalDate.of(2000, 2, 1));

        bookRepository.save(book);
        bookRepository.save(book2);

        //When
        Optional<Book> testBook = bookRepository.findById(book2.getId());

        //Then
        assertTrue(testBook.isPresent());
        assertEquals(Optional.of(book2), testBook);
        assertEquals("ghi", testBook.get().getTitle());
        assertEquals("jkl", testBook.get().getAuthor());
        assertEquals(LocalDate.of(2000,2,1), testBook.get().getPublishDate());
    }

    @Transactional
    @Test
    public void testSave() {
        //Given
        long sizeOfDatabaseBeforeTest = bookRepository.count();

        Book book = new Book(5L, "abc", "def", LocalDate.of(1992,12,2));
        Book book2 = new Book(6L, "ghi", "jkl", LocalDate.of(2000, 2, 1));

        //When
        bookRepository.save(book);
        bookRepository.save(book2);

        //Then
        assertEquals(2L, bookRepository.count() - sizeOfDatabaseBeforeTest);





    }

}