package com.pioneers.medmartbck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pioneers.medmartbck.model.ProductBatch;

public interface ProductBatchRepository extends JpaRepository <ProductBatch, Long> {

    @Query("SELECT SUM(i.quantity) FROM ProductBatch i")
    Long getTotalProductBatchesCount();
}
