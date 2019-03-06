package com.crud.kodillalibrary.copy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Wrong id - copy doesn't exist.")
public class CopyNotFoundException extends RuntimeException {

}
