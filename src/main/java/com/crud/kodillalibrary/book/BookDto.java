package com.crud.kodillalibrary.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
class BookDto {
    private long id;
    private String title;
    private String author;
    private LocalDate publishDate;

    public BookDto(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
