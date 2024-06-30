package com.pioneers.medmartbck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pioneers.medmartbck.model.Supplier;

public interface SupplierRepository extends JpaRepository <Supplier, Long> {
    
}
