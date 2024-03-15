package com.liquor.service.lib.liquorservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    public ResourceNotFoundException(String message) {
        super(message);
    }

    @SuppressWarnings("unused")
    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

