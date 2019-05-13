package com.crud.kodillalibrary.rent;

import com.crud.kodillalibrary.book.Book;
import com.crud.kodillalibrary.copy.Copy;
import com.crud.kodillalibrary.copy.Status;
import com.crud.kodillalibrary.reader.Reader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RentServiceTestSuite {
    @InjectMocks
    private RentService rentService;

    @Mock
    private RentRepository rentRepository;

    @Test
    public void testAddRent(){
        //Given
        Book book = new Book("testTitle", "testAuthor", LocalDate.of(2011, 10, 9));
        Copy copy = new Copy( book, Status.AVAILABLE);
        Reader reader = new Reader("jan", "kowalski", LocalDate.of(2018, 5, 5));
        Rent rent = new Rent(LocalDate.of(2019, 4, 5), LocalDate.of(2019, 5, 6), reader, copy);
        Rent rent2 = new Rent(LocalDate.of(2018, 4, 5), LocalDate.of(2018, 5, 6), reader, copy);

        when(rentRepository.save(any(Rent.class))).thenReturn(rent);

        //When
        Rent testRent = rentService.addRent(rent2);

        //Then
        assertEquals(rent.getId(), testRent.getId());
        assertEquals(rent.getRentDate(), testRent.getRentDate());
        assertEquals(rent.getReturnDate(), testRent.getReturnDate());
        assertEquals(rent.getReader(), testRent.getReader());
        assertEquals(rent.getCopy(), testRent.getCopy());
    }

}