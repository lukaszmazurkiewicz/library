package com.crud.kodillalibrary.book;

import lombok.Value;

import java.time.LocalDate;

@Value
class BookDto {
    private final long id;
    private final String title;
    private final String author;
    private final LocalDate publishDate;

}
