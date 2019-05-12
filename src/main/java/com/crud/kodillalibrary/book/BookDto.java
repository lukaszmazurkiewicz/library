package com.crud.kodillalibrary.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class BookDto {
    private long id;
    private String title;
    private String author;
    private LocalDate publishDate;
}
