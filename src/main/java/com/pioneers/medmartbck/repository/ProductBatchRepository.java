package com.pioneers.medmartbck.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pioneers.medmartbck.model.ProductBatch;

public interface ProductBatchRepository extends JpaRepository <ProductBatch, Long> {

    @Query("SELECT SUM(i.quantity) FROM ProductBatch i")
    Long getTotalProductBatchesCount();
    List<ProductBatch> findByExpirationDateBetween(LocalDate startDate, LocalDate endDate);
}
