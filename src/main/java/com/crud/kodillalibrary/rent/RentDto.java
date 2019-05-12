package com.crud.kodillalibrary.rent;

import lombok.Value;

import java.time.LocalDate;

@Value
class RentDto {
    private long id;
    private long readerId;
    private long copyId;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
