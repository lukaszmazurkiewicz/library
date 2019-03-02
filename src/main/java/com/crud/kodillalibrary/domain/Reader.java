package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "READERS")
public class Reader {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FIRSTNAME")
    @NotNull
    private String firstName;

    @Column(name = "LASTNAME")
    @NotNull
    private String lastName;

    @Column(name = "CREATEACCOUNTDATE")
    @NotNull
    private LocalDate createAccountDate;
}
