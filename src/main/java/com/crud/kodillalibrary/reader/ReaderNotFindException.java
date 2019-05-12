package com.crud.kodillalibrary.reader;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ReaderNotFindException extends RuntimeException {
    public ReaderNotFindException(String message) {
        super(message);
    }
}