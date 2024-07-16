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

import com.pioneers.medmartbck.NotFoundException.SalesNotFoundException;
import com.pioneers.medmartbck.model.Sales;
import com.pioneers.medmartbck.repository.SalesRepository;

@RestController
@RequestMapping("api/v1/sales")
public class SalesController {
    
    private final SalesRepository repo;

    public SalesController(SalesRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Sales> getSales() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Sales getSale(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new SalesNotFoundException(id));
    }

    @PostMapping("/create")
    public String create(@RequestBody Sales newSale) {
        repo.save(newSale);
        return "A new sale is added.";
    }

    @PutMapping("/edit/{id}")
    public Sales update(@PathVariable Long id, @RequestBody Sales newSale) {
        return repo.findById(id)
                .map(sale -> {
                    sale.setTotalAmount(newSale.getTotalAmount());
                    return repo.save(sale);
                }).orElseGet(() -> {
                    return repo.save(newSale);
                });
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "The sale is deleted!";
    }

}
