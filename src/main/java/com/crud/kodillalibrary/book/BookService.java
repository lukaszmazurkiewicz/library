package com.crud.kodillalibrary.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    List<Book> getBooks() {
        return bookRepository.findAll();
    }

    Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    Book addBook(final Book book) {
        return bookRepository.save(book);
    }
}
