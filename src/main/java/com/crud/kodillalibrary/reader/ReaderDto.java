package com.crud.kodillalibrary.reader;

import lombok.Value;

import java.time.LocalDate;

@Value
class ReaderDto {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate createAccountDate;
}
