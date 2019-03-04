package com.crud.kodillalibrary.reader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class ReaderDto {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate createAccountDate;
}
