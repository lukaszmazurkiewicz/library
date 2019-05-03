package com.crud.kodillalibrary.rent;

import com.crud.kodillalibrary.copy.Copy;
import com.crud.kodillalibrary.reader.Reader;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "RENTS")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "RENT_DATE")
    @NotNull
    private LocalDate rentDate;

    @Setter
    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COPY_ID")
    private Copy copy;

    public Rent(@NotNull LocalDate rentDate, LocalDate returnDate, Reader reader, Copy copy) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.reader = reader;
        this.copy = copy;
    }
}
