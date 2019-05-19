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
import java.util.Optional;

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

        Book book = new Book("ja", "ty", LocalDate.of(2010, 12, 12));

        bookRepository.save(book);

        Copy copy = new Copy(book, Status.AVAILABLE);
        Copy copy2 = new Copy(book, Status.RENTED);

        copyRepository.save(copy);
        copyRepository.save(copy2);

        //When
        List<Copy> copies = copyRepository.findAll();

        //Then
        assertEquals(2, copies.size() - sizeOfDatabaseBeforeTest);
        assertTrue(copies.contains(copy));
        assertTrue(copies.contains(copy2));
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Book book = new Book("ja", "ty", LocalDate.of(2010, 12, 12));

        bookRepository.save(book);

        Copy copy = new Copy(book, Status.AVAILABLE);
        Copy copy2 = new Copy(book, Status.RENTED);

        copyRepository.save(copy);
        copyRepository.save(copy2);

        //When
        Optional<Copy> testCopy = copyRepository.findById(copy2.getId());

        //Then
        assertTrue(testCopy.isPresent());
        assertEquals(Optional.of(copy2), testCopy);
        assertEquals(book, testCopy.get().getBook());
        assertEquals(Status.RENTED, testCopy.get().getStatus());
    }

    @Transactional
    @Test
    public void testSave() {
        //Given
        long sizeOfDatabaseBeforeTest = copyRepository.count();

        Book book = new Book("ja", "ty", LocalDate.of(2010, 12, 12));

        bookRepository.save(book);

        Copy copy = new Copy(book, Status.AVAILABLE);
        Copy copy2 = new Copy(book, Status.RENTED);

        //When
        copyRepository.save(copy);
        copyRepository.save(copy2);

        //Then
        assertEquals(2L, copyRepository.count() - sizeOfDatabaseBeforeTest);
    }

    @Transactional
    @Test
    public void testCountByBook_IdAndAndStatus() {
        //Given
        Book book = new Book("ja", "ty", LocalDate.of(2010, 12, 12));

        bookRepository.save(book);

        Copy copy = new Copy(book, Status.AVAILABLE);
        Copy copy2 = new Copy(book, Status.RENTED);
        Copy copy3 = new Copy(book, Status.RENTED);

        copyRepository.save(copy);
        copyRepository.save(copy2);
        copyRepository.save(copy3);

        //When
        long howManyAvailable = copyRepository.countByBook_IdAndAndStatus(book.getId(), Status.AVAILABLE);
        long howManyRented = copyRepository.countByBook_IdAndAndStatus(book.getId(), Status.RENTED);
        long howManyDestroyed = copyRepository.countByBook_IdAndAndStatus(book.getId(), Status.DESTROYED);

        //Then
        assertEquals(1L, howManyAvailable);
        assertEquals(2L, howManyRented);
        assertEquals(0L, howManyDestroyed);

    }

}