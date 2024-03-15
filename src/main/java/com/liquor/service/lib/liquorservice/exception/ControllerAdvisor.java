package com.liquor.service.lib.liquorservice.exception;

import com.liquor.service.lib.liquorservice.dto.ErrorDetailsDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(404).body(errorDetails);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleApiException(BadRequestException exception, WebRequest request) {

        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(400).body(errorDetails);
    }
    @ExceptionHandler(InternalServerError.class)
    public  ResponseEntity<?> handleserverError(InternalServerError exception, WebRequest request){
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(500).body(errorDetails);
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<?> handleDuplicateResourceException(DuplicateResourceException exception, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(409).body(errorDetails);
    }
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<?> handleForbiddenException(ForbiddenException exception, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(403).body(errorDetails);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(500).body(errorDetails);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatusCode status,
                                                               WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), "Validation Error", ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorDetails, headers, status);
    }
}
