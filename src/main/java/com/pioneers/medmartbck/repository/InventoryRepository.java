package com.pioneers.medmartbck.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pioneers.medmartbck.model.Inventory;

public interface InventoryRepository extends JpaRepository <Inventory, Long> {

    @Query("SELECT SUM(i.quantity) FROM Inventory i")
    Long getTotalInventoryCount();

    Optional<Inventory> findByProductBatchId(Long productBatchId);
}
