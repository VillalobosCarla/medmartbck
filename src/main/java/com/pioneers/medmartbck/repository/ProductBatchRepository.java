package com.pioneers.medmartbck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pioneers.medmartbck.model.ProductBatch;

public interface ProductBatchRepository extends JpaRepository <ProductBatch, Long> {

}
