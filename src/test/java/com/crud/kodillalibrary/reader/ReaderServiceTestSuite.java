package com.crud.kodillalibrary.reader;

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
public class ReaderServiceTestSuite {
    @InjectMocks
    private ReaderService readerService;

    @Mock
    private ReaderRepository readerRepository;

    @Test
    public void testGetReaderById() {
        //Given
        Reader reader = new Reader("jan", "kowalski", LocalDate.of(2018, 5, 5));

        when(readerRepository.findById(anyLong())).thenReturn(Optional.of(reader));

        //When
        Reader testReader = readerService.getReaderById(reader.getId());

        //Then
        assertEquals(reader.getId(), testReader.getId());
        assertEquals(reader.getFirstName(), testReader.getFirstName());
        assertEquals(reader.getLastName(), testReader.getLastName());
        assertEquals(reader.getCreateAccountDate(), testReader.getCreateAccountDate());
    }

    @Test
    public void testAddReader() {
        //Given
        Reader reader = new Reader("jan", "kowalski", LocalDate.of(2018, 5, 5));
        Reader reader2 = new Reader("jerzy", "nowak", LocalDate.of(2017, 4, 4));

        when(readerRepository.save(any(Reader.class))).thenReturn(reader);

        //When
        Reader testReader = readerService.addReader(reader2);

        //Then
        assertEquals(reader.getId(), testReader.getId());
        assertEquals(reader.getFirstName(), testReader.getFirstName());
        assertEquals(reader.getLastName(), testReader.getLastName());
        assertEquals(reader.getCreateAccountDate(), testReader.getCreateAccountDate());
    }

}