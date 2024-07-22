package com.pioneers.medmartbck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pioneers.medmartbck.model.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

    @Query("SELECT SUM(i.quantity) FROM Inventory i")
    Long getTotalInventoryCount();
}
