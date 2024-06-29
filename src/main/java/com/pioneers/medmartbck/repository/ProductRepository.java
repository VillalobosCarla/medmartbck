package com.pioneers.medmartbck.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pioneers.medmartbck.model.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
