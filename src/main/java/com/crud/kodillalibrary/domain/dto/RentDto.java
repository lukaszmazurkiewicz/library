package com.crud.kodillalibrary.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {
    private long readerId;
    private long pieceId;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
