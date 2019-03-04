package com.crud.kodillalibrary.rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
class RentDto {
    private long id;
    private long readerId;
    private long pieceId;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
