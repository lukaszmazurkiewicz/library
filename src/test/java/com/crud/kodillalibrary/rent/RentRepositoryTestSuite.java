package com.crud.kodillalibrary.rent;

import com.crud.kodillalibrary.book.Book;
import com.crud.kodillalibrary.book.BookRepository;
import com.crud.kodillalibrary.copy.Copy;
import com.crud.kodillalibrary.copy.CopyRepository;
import com.crud.kodillalibrary.copy.Status;
import com.crud.kodillalibrary.reader.Reader;
import com.crud.kodillalibrary.reader.ReaderRepository;
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
public class RentRepositoryTestSuite {
    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Transactional
    @Test
    public void testAll() {
        //Given
        long sizeOfDatabaseBeforeTest = rentRepository.count();

        Book book = new Book(1, "ja", "ty", LocalDate.of(2010, 12, 12));
        bookRepository.save(book);

        Copy copy = new Copy(book, Status.AVAILABLE);
        Copy copy2 = new Copy(book, Status.RENTED);
        copyRepository.save(copy);
        copyRepository.save(copy2);

        Reader reader = new Reader(1L, "jan", "janowy", LocalDate.of(1956, 6, 6));
        Reader reader2 = new Reader(2L, "tomasz", "tomecki", LocalDate.of(2000, 3, 3));
        readerRepository.save(reader);
        readerRepository.save(reader2);

        Rent rent = new Rent(LocalDate.of(2019, 4, 30), null, reader, copy);
        Rent rent2 = new Rent(LocalDate.of(2019, 3, 6), LocalDate.of(2019, 4, 1), reader2, copy2);
        rentRepository.save(rent);
        rentRepository.save(rent2);

        //When
        List<Rent> rents = rentRepository.findAll();

        //Then
        assertEquals(2, rents.size() - sizeOfDatabaseBeforeTest);
        assertTrue(rents.contains(rent));
        assertTrue(rents.contains(rent2));
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Book book = new Book(1, "ja", "ty", LocalDate.of(2010, 12, 12));
        bookRepository.save(book);

        Copy copy = new Copy(book, Status.AVAILABLE);
        copyRepository.save(copy);

        Reader reader = new Reader(1L, "jan", "janowy", LocalDate.of(1956, 6, 6));
        readerRepository.save(reader);

        Rent rent = new Rent(LocalDate.of(2019, 4, 30), null, reader, copy);
        rentRepository.save(rent);

        //When
        Optional<Rent> testRent = rentRepository.findById(rent.getId());

        //Then
        assertTrue(testRent.isPresent());
        assertEquals(Optional.of(rent), testRent);
        assertEquals(LocalDate.of(2019, 4, 30), testRent.get().getRentDate());
        assertNull(testRent.get().getReturnDate());
        assertEquals(reader, testRent.get().getReader());
        assertEquals(copy, testRent.get().getCopy());
    }

    @Transactional
    @Test
    public void testSave() {
        //Given
        long sizeOfDatabaseBeforeTest = rentRepository.count();

        Book book = new Book(1, "ja", "ty", LocalDate.of(2010, 12, 12));
        bookRepository.save(book);

        Copy copy = new Copy(book, Status.AVAILABLE);
        Copy copy2 = new Copy(book, Status.RENTED);
        copyRepository.save(copy);
        copyRepository.save(copy2);

        Reader reader = new Reader(1L, "jan", "janowy", LocalDate.of(1956, 6, 6));
        Reader reader2 = new Reader(2L, "tomasz", "tomecki", LocalDate.of(2000, 3, 3));
        readerRepository.save(reader);
        readerRepository.save(reader2);

        Rent rent = new Rent(LocalDate.of(2019, 4, 30), null, reader, copy);
        Rent rent2 = new Rent(LocalDate.of(2019, 3, 6), LocalDate.of(2019, 4, 1), reader2, copy2);

        //When
        rentRepository.save(rent);
        rentRepository.save(rent2);

        //Then
        assertEquals(2L, rentRepository.count() - sizeOfDatabaseBeforeTest);

    }


}