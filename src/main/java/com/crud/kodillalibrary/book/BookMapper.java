package com.crud.kodillalibrary.book;

import org.springframework.stereotype.Service;

@Service
class BookMapper {

    Book mapToBook(BookDto bookDto) {

        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublishDate());
    }

}
