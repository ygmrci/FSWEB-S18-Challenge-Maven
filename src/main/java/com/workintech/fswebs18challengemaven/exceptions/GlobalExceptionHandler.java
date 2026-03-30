package com.workintech.fswebs18challengemaven.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CardException.class)
    public ResponseEntity<CardErrorResponse> handleCardException(CardException ex) {
        log.error("Card exception: {}", ex.getMessage());
        CardErrorResponse error = new CardErrorResponse(ex.getMessage());
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CardErrorResponse> handleGenericException(Exception ex) {
        log.error("Unexpected exception", ex);
        CardErrorResponse error = new CardErrorResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
