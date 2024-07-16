package com.pioneers.medmartbck.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pioneers.medmartbck.NotFoundException.InventoryNotFoundException;

public class InventoryExceptionHandler {
    @ExceptionHandler(InventoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String InventoryNotFoundException(InventoryNotFoundException e){
        return e.getMessage();
    }

}
