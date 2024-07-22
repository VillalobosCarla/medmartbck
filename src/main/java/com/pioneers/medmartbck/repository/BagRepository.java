package com.pioneers.medmartbck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pioneers.medmartbck.model.Bag;

public interface BagRepository extends JpaRepository<Bag, Long> {
 List<Bag> findAllByUserId(Long id);
}
