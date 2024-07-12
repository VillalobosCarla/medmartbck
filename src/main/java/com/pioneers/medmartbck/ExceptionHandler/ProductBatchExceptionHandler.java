package com.pioneers.medmartbck.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductBatchExceptionHandler {
    @ExceptionHandler(com.pioneers.medmartbck.NotFoundException.ProductBatchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    
    String ProductBatchNotFoundException(com.pioneers.medmartbck.NotFoundException.ProductBatchNotFoundException e){
        return e.getMessage();
    }

}
