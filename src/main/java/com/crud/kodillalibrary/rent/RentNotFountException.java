package com.crud.kodillalibrary.rent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RentNotFountException extends RuntimeException {
    public RentNotFountException(String message) {
        super(message);
    }
}
