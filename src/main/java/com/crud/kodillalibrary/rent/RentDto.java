package com.crud.kodillalibrary.rent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
class RentDto {
    private long id;
    private long readerId;
    private long copyId;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
