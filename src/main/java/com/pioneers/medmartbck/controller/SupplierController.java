package com.pioneers.medmartbck.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pioneers.medmartbck.NotFoundException.SupplierNotFoundException;
import com.pioneers.medmartbck.model.Supplier;
import com.pioneers.medmartbck.repository.SupplierRepository;

@RestController
public class SupplierController {
    
    SupplierRepository repo;

    public SupplierController(SupplierRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/suppliers")
    public List<Supplier> getSuppliers() {
        return repo.findAll();
    }

    @GetMapping("/supplier/{id}")
    public Supplier getSupplier(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new SupplierNotFoundException(id));
    }

    @PostMapping("/supplier/create")
    public String create(@RequestBody Supplier newSupplier) {
        repo.save(newSupplier);
        return "A new supplier is added.";
    }

    @PutMapping("/supplier/edit/{id}")
    public Supplier update(@PathVariable Long id, @RequestBody Supplier newSupplier) {
        return repo.findById(id)
                .map(supplier -> {
                    supplier.setSupplierName(newSupplier.getSupplierName());
                    supplier.setContactInfo(newSupplier.getContactInfo());
                    return repo.save(supplier);
                }).orElseGet(() -> {
                    return repo.save(newSupplier);
                });
    }

    @DeleteMapping("/supplier/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "The supplier is deleted!";
    }
}
