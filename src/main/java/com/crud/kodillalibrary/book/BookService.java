package com.crud.kodillalibrary.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));
    }

    Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
