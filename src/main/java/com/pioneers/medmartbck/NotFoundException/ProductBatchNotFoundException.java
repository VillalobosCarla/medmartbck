package com.pioneers.medmartbck.NotFoundException;

public class ProductBatchNotFoundException extends RuntimeException {
    public ProductBatchNotFoundException(Long id){
        super("Could not found product batch with " + id );
    }
}
