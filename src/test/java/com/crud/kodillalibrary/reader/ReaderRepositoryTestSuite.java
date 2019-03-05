package com.crud.kodillalibrary.reader;

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
public class ReaderRepositoryTestSuite {
    @Autowired
    private ReaderRepository readerRepository;

    @Transactional
    @Test
    public void testFindAll() {
        //Given
        long sizeOfDatabaseBeforeTest = readerRepository.count();

        Reader reader = new Reader(1L, "jan", "janowy", LocalDate.of(1956, 6, 6));
        Reader reader2 = new Reader(2L, "tomasz", "tomecki", LocalDate.of(2000, 3, 3));

        readerRepository.save(reader);
        readerRepository.save(reader2);

        //When
        List<Reader> readers = readerRepository.findAll();

        //Then
        assertEquals(2L, readers.size() - sizeOfDatabaseBeforeTest);
        assertTrue(readers.contains(reader));
        assertTrue(readers.contains(reader2));
    }

    @Transactional
    @Test
    public void testFindById() {
        //Given
        Reader reader = new Reader(1L, "jan", "janowy", LocalDate.of(1956, 6, 6));
        Reader reader2 = new Reader(2L, "tomasz", "tomecki", LocalDate.of(2000, 3, 3));

        readerRepository.save(reader);
        readerRepository.save(reader2);

        //When
        Optional<Reader> testReader = readerRepository.findById(reader.getId());

        //Then
        assertTrue(testReader.isPresent());
        assertEquals(Optional.of(reader), testReader);
        assertEquals("jan", testReader.get().getFirstName());
        assertEquals("janowy", testReader.get().getLastName());
        assertEquals(LocalDate.of(1956,6,6), testReader.get().getCreateAccountDate());
    }

    @Transactional
    @Test
    public void testSave() {
        //Given
        long sizeOfDatabaseBeforeTest = readerRepository.count();

        Reader reader = new Reader(5L, "jan", "janowy", LocalDate.of(1956, 6, 6));
        Reader reader2 = new Reader(6L, "tomasz", "tomecki", LocalDate.of(2000, 3, 3));

        //When
        readerRepository.save(reader);
        readerRepository.save(reader2);

        //Then
        assertEquals(2L, readerRepository.count() - sizeOfDatabaseBeforeTest);
    }
}