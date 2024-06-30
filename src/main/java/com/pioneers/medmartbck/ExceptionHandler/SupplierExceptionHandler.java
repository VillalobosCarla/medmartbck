package com.pioneers.medmartbck.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pioneers.medmartbck.NotFoundException.SupplierNotFoundException;

@RestControllerAdvice
public class SupplierExceptionHandler {
    @ExceptionHandler(SupplierNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String productNotFoundHandler(SupplierNotFoundException e) {
        return e.getMessage();
    }

}
