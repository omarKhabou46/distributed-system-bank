package com.enset.customerservice.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomerNotFoundException.class})
    public ErrorMessage handleCustomerNotFoundException(CustomerNotFoundException e, HttpServletResponse response) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .status(response.getStatus())
                .build();
        return errorMessage;
    }

}
