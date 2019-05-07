package com.crud.kodillalibrary.book;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/books")
@AllArgsConstructor
@Slf4j
class BookController {

    private final BookMapper bookMapper;
    private final BookService bookService;

    @PostMapping
    Long addBook(@RequestBody BookDto bookDto) {
        log.info("Add book called. BookDto [{}]", bookDto);

        Book book = bookService.addBook(bookMapper.mapToBook(bookDto));
        return book.getId();

    }
}
