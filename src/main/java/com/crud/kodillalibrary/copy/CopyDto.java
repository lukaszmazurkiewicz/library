package com.crud.kodillalibrary.copy;

import com.crud.kodillalibrary.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class CopyDto {
    private long id;
    private Book book;
    private String status;
}
