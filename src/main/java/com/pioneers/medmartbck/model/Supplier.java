package com.pioneers.medmartbck.model;

import java.time.LocalDateTime;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "supplier", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
    private Set<ProductBatch> productBatches;

    @NotBlank
    @Column(name = "supplier_name")
    private String supplierName;

    @NotBlank
    @Column(name = "contact_info")
    private String contactInfo;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    Supplier(){}
    
    public Supplier(Set<ProductBatch> productBatches, @NotBlank String supplierName, @NotBlank String contactInfo) {
        this.productBatches = productBatches;
        this.supplierName = supplierName;
        this.contactInfo = contactInfo;
    }

    public Long getId() {
        return id;
    }

    public Set<ProductBatch> getProductBatches() {
        return productBatches;
    }

    public void setProductBatches(Set<ProductBatch> productBatches) {
        this.productBatches = productBatches;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
