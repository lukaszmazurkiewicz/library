package com.crud.kodillalibrary.copy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {

    RENTED("Rented"),
    AVAILABLE("Available"),
    DESTROYED("Destroyed");

    private String text;
}
