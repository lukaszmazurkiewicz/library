package com.crud.kodillalibrary.reader;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
class ReaderDto {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate createAccountDate;

    public ReaderDto(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
