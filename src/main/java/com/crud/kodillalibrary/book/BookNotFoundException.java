package com.crud.kodillalibrary.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Wrong id - book doesn't exist.")
public class BookNotFoundException extends RuntimeException {

}
