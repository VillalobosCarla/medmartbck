package com.pioneers.medmartbck.model;

import java.util.Optional;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Bag {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long bagId;

 @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_bag", 
      joinColumns = 
        { @JoinColumn(name = "bag_id", referencedColumnName = "bagId") },
      inverseJoinColumns = 
        { @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
    private Set<Product> product;

    private Long userId;

    private int numberOfOrder;


    public Bag(){}

    

    public Long getBagId() {
        return bagId;
    }



    public int getNumberOfOrder() {
        return numberOfOrder;
    }


    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Product> getProduct() {
        return product;
    }
    
    
    
    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    
}
