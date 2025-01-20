package com.tpe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArgumentExpectedException extends RuntimeException {
    public ArgumentExpectedException(String message) {
        super(message);
    }
}
