package com.pioneers.medmartbck.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_batches")
public class ProductBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_batches_id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    
    @NotNull
    @Column(name = "batch_number")
    private Long batchNumber;
    
    @NotNull
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    
    @NotNull
    private Integer quantity;

    @NotNull
    @Column(name = "supplier_price")
    private Double supplierPrice;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    ProductBatch(){}

    public ProductBatch(@NotNull Product product, Supplier supplier, @NotNull Long batchNumber,
            @NotNull LocalDate expirationDate, @NotNull Integer quantity, @NotNull Double supplierPrice) {
        this.product = product;
        this.supplier = supplier;
        this.batchNumber = batchNumber;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.supplierPrice = supplierPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Long getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Long batchNumber) {
        this.batchNumber = batchNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(Double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
