package com.crud.kodillalibrary.book;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
class BookDto {
    private long id;
    private String title;
    private String author;
    private LocalDate publishDate;
}
