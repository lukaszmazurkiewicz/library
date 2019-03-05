package com.crud.kodillalibrary.book;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class BookMapper {
    Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublishDate());
    }

    BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublishDate());
    }

    List<BookDto> mapToBookDtoList(final List<Book> books) {
        return books.stream()
                .map(b -> mapToBookDto(b))
                .collect(Collectors.toList());
    }
}
