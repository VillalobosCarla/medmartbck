package com.pioneers.medmartbck.NotFoundException;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(Long id) {
        super("Could not find supplier " + id);
    }
}
