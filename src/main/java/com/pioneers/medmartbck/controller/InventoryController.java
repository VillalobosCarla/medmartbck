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

import com.pioneers.medmartbck.NotFoundException.InventoryNotFoundException;
import com.pioneers.medmartbck.model.Inventory;
import com.pioneers.medmartbck.repository.InventoryRepository;

@RestController
@RequestMapping("api/v1/inventory")
public class InventoryController {

    private final InventoryRepository repo;

    public InventoryController(InventoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Inventory> getAllInventory() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Inventory getInventory(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new InventoryNotFoundException(id));
    }

    @PostMapping("/create")
    public String create(@RequestBody Inventory newInventory) {
        repo.save(newInventory);
        return "A new inventory item is added.";
    }

    @PutMapping("/edit/{id}")
    public Inventory update(@PathVariable Long id, @RequestBody Inventory newInventory) {
        return repo.findById(id)
                .map(inventory -> {
                    inventory.setProductBatch(newInventory.getProductBatch());
                    inventory.setQuantity(newInventory.getQuantity());
                    return repo.save(inventory);
                }).orElseGet(() -> {
                    return repo.save(newInventory);
                });
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "The inventory item is deleted!";
    }

}
