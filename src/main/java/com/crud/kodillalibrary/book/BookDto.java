package com.crud.kodillalibrary.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class BookDto {
    private long id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public BookDto(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }
}
