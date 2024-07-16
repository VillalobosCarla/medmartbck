package com.pioneers.medmartbck.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pioneers.medmartbck.NotFoundException.SalesDetailsNotFoundException;

public class SalesDetailsExceptionHandler {
    @ExceptionHandler(SalesDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String salesDeatailsNotFoundException(SalesDetailsNotFoundException e){
        return e.getMessage();
    }

}
