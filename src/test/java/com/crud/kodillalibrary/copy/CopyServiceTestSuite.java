package com.crud.kodillalibrary.copy;

import com.crud.kodillalibrary.book.Book;
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
public class CopyServiceTestSuite {
    @InjectMocks
    private CopyService copyService;

    @Mock
    private CopyRepository copyRepository;

    @Test
    public void testGetCopyById() {
        //Given
        Book book = new Book("testTitle", "testAuthor", LocalDate.of(2011, 10, 9));
        Copy copy = new Copy( book, Status.AVAILABLE);

        when(copyRepository.findById(anyLong())).thenReturn(Optional.of(copy));

        //When
        Copy testCopy = copyService.getCopyById(copy.getId());

        //Then
        assertEquals(copy.getId(), testCopy.getId());
        assertEquals(copy.getBook(), testCopy.getBook());
        assertEquals(copy.getStatus(), testCopy.getStatus());
    }

    @Test
    public void testAddCopy() {
        //Given
        Book book = new Book("testTitle", "testAuthor", LocalDate.of(2011, 10, 9));
        Copy copy = new Copy( book, Status.AVAILABLE);
        Copy copy2 = new Copy( book, Status.DESTROYED);

        when(copyRepository.save(any(Copy.class))).thenReturn(copy);

        //When
        Copy testCopy = copyService.addCopy(copy2);

        //Then
        assertEquals(copy.getId(), testCopy.getId());
        assertEquals(copy.getBook(), testCopy.getBook());
        assertEquals(copy.getStatus(), testCopy.getStatus());
    }
}