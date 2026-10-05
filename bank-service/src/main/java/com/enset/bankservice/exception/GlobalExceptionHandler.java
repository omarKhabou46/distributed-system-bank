package com.enset.bankservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BankAccountNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(
            BankAccountNotFoundException e) {

        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }
}
