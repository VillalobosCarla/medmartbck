package com.pioneers.medmartbck.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pioneers.medmartbck.model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT SUM(s.totalAmount) FROM Sales s WHERE s.saleDate BETWEEN :start AND :end")
    Double sumBySaleDateBetween(LocalDateTime start, LocalDateTime end);
}
