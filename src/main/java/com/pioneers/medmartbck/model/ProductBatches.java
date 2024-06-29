package com.pioneers.medmartbck.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ProductBatches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_batches_id")
    private Long id;

    @NotBlank
    @Column(name = "product_id")
    private Long productId;
    @NotBlank
    private Long supplierId;
    @NotBlank
    private int batchNumber;
    @NotBlank
    private Date expirationDate;
    @NotBlank
    private int quantity;
    @NotBlank
    private Double supplierPrice;

    @CreationTimestamp
    @Column(updatable = false, name = "create_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
