package com.pioneers.medmartbck.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "sale")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_id")
    private Long id;

    @CreationTimestamp
    @Column(updatable = false, name = "sale_date")
    private LocalDateTime saleDate;

    @NotNull
    @Column(name = "total_amount")
    private double totalAmount;

    public Sales() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
