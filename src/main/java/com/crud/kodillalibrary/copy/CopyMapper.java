package com.crud.kodillalibrary.copy;

import com.crud.kodillalibrary.book.Book;
import com.crud.kodillalibrary.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
class CopyMapper {
    private final BookService bookService;

    Copy mapToCopy(final CopyDto copyDto) {
        Book book = bookService.getBookById(copyDto.getBookId());
        return new Copy(
                copyDto.getId(),
                book,
                copyDto.getStatus());
    }

    CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getBook().getId(),
                copy.getStatus());
    }
}
