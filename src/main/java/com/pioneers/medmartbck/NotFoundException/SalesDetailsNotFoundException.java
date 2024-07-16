package com.pioneers.medmartbck.NotFoundException;

public class SalesDetailsNotFoundException extends RuntimeException {
    public SalesDetailsNotFoundException(Long id){
        super("Could not found product with " + id );
    }
}
