package com.crud.kodillalibrary.copy;

import com.crud.kodillalibrary.book.Book;
import com.crud.kodillalibrary.book.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CopyRepositoryTestSuite {
    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        long sizeOfDatabaseBeforeTest = copyRepository.count();

        System.out.println(sizeOfDatabaseBeforeTest + " 1111111111111111111");

        Book book = new Book(1,"ja","ty", LocalDate.of(2010,12,12));

        Book book2 = new Book(2,"ty","ja", LocalDate.now());
        bookRepository.save(book);
        bookRepository.save(book2);

        System.out.println(bookRepository.count() + "2222222222222222222222");

        Copy copy = new Copy(1,book, Status.AVAILABLE);
        Copy copy2 = new Copy(2, book2, Status.RENTED);

        copyRepository.save(copy);
        copyRepository.save(copy2);

        System.out.println(copyRepository.count() + "3333333333333");

        //When
        List<Copy> copies = copyRepository.findAll();

        System.out.println(copies.size() + "44444444444");

        //Then
        assertEquals(2, copies.size() - sizeOfDatabaseBeforeTest);
        //assertTrue(copies.contains(copy));
        //assertTrue(copies.contains(copy2));
    }


}