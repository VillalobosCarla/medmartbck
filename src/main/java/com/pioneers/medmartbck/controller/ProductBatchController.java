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

import com.pioneers.medmartbck.NotFoundException.ProductBatchNotFoundException;
import com.pioneers.medmartbck.model.ProductBatch;
import com.pioneers.medmartbck.repository.ProductBatchRepository;

@RestController
@RequestMapping("api/v1/batch")
public class ProductBatchController {

    ProductBatchRepository repo;

    public ProductBatchController(ProductBatchRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<ProductBatch> getAllProductBatches() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ProductBatch getProductBatch(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ProductBatchNotFoundException(id));
    }

    @PostMapping("/create")
    public String create(@RequestBody ProductBatch newProductBatch) {
        repo.save(newProductBatch);
        return "A new product batch is added.";
    }

    @PutMapping("/edit/{id}")
    public ProductBatch update(@PathVariable Long id, @RequestBody ProductBatch newProductBatch) {
        return repo.findById(id)
                .map(productBatch -> {
                    productBatch.setProduct(newProductBatch.getProduct());
                    productBatch.setSupplier(newProductBatch.getSupplier());
                    productBatch.setBatchNumber(newProductBatch.getBatchNumber());
                    productBatch.setExpirationDate(newProductBatch.getExpirationDate());
                    productBatch.setQuantity(newProductBatch.getQuantity());
                    productBatch.setSupplierPrice(newProductBatch.getSupplierPrice());
                    return repo.save(productBatch);
                }).orElseGet(() -> {
                    return repo.save(newProductBatch);
                });
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "The product batch is deleted!";
    }

}
