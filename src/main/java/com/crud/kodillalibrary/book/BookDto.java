package com.crud.kodillalibrary.book;

import lombok.Data;

import java.time.LocalDate;

@Data
class BookDto {
    private long id;
    private String title;
    private String author;
    private LocalDate publishDate;
}
