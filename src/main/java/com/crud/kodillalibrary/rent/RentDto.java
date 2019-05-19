package com.crud.kodillalibrary.rent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
class RentDto {
    private long id;
    private long readerId;
    private long copyId;
    private LocalDate rentDate;
    private LocalDate returnDate;

    public RentDto(long id, long readerId, long copyId) {
        this.id = id;
        this.readerId = readerId;
        this.copyId = copyId;
    }
}
