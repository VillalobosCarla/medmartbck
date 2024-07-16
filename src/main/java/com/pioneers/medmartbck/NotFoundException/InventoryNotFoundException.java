package com.pioneers.medmartbck.NotFoundException;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(Long id){
        super("Could not found product with " + id );
    }

}
