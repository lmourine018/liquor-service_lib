package com.liquor.service.lib.liquorservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    public ForbiddenException(String message) {
        super(message);
    }

    @SuppressWarnings("unused")
    public ForbiddenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}