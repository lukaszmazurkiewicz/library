package com.crud.kodillalibrary.rent;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Wrong id - rent doesn't exist.")
public class RentNotFountException extends RuntimeException {

}
