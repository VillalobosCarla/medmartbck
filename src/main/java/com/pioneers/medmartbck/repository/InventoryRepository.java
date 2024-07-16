package com.pioneers.medmartbck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pioneers.medmartbck.model.Inventory;

public interface InventoryRepository extends JpaRepository <Inventory, Long> {

}
