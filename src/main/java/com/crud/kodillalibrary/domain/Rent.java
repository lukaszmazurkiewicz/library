package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "RENTS")
public class Rent {
    @Column(name = "READER_ID")
    @NotNull
    private long readerId;

    @Column(name = "PIECE_ID")
    @NotNull
    private long pieceId;

    @Column(name = "RENT_DATE")
    @NotNull
    private LocalDate rentDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;
}
