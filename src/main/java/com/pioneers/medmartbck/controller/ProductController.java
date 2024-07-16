package com.pioneers.medmartbck.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pioneers.medmartbck.NotFoundException.ProductNotFoundException;
import com.pioneers.medmartbck.model.Product;
import com.pioneers.medmartbck.repository.ProductRepository;


@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    
    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Product geProduct(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id));
    }

    @PostMapping("/create")
    public String create(@RequestBody Product newProduct) {
        repo.save(newProduct);
        return "A new product is added.";
    }

    @PutMapping("/edit/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product newProduct) {
        return repo.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setGenericName(newProduct.getGenericName());
                    product.setCategory(newProduct.getCategory());
                    product.setPrice(newProduct.getPrice());
                    product.setProductDescription(newProduct.getProductDescription());
                    product.setImageUrl(newProduct.getImageUrl()); 
                    return repo.save(product);
                }).orElseGet(() -> {
                    return repo.save(newProduct);
                });
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "The product is deleted!";
    }

}
