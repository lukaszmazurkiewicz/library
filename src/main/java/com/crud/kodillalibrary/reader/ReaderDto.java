package com.crud.kodillalibrary.reader;

import lombok.Data;

import java.time.LocalDate;

@Data
class ReaderDto {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate createAccountDate;
}
