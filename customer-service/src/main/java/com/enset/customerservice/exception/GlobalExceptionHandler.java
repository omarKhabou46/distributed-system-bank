package com.enset.customerservice.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(
            CustomerNotFoundException e) {

        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }
}
