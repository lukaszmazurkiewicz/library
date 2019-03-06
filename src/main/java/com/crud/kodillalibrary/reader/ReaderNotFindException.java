package com.crud.kodillalibrary.reader;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Wrong id - reader doesn't exist.")
public class ReaderNotFindException extends RuntimeException {

}