package com.liquor.service.lib.liquorservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerError extends RuntimeException {
    @Serial
    private static final Long SerialVersionUuid = 1L;
    @SuppressWarnings("unused")
    public InternalServerError(String message){
        super(message);
    }
    @SuppressWarnings("unused")
    public InternalServerError(String message, Throwable throwable){
        super(message,throwable);
    }
}

