package com.pioneers.medmartbck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pioneers.medmartbck.model.SalesDetails;

public interface SalesDetailsRepository extends JpaRepository <SalesDetails, Long> {
    List<SalesDetails> findBySalesId(Long salesId);
}
