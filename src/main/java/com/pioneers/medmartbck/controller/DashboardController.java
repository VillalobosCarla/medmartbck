package com.pioneers.medmartbck.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pioneers.medmartbck.repository.InventoryRepository;
import com.pioneers.medmartbck.repository.ProductBatchRepository;
import com.pioneers.medmartbck.repository.SalesRepository;

@RestController
@RequestMapping("api/v1/dashboard")
public class DashboardController {

    private final InventoryRepository inventoryRepo;
    private final ProductBatchRepository productBatchRepo;
    private final SalesRepository salesRepo;

    public DashboardController(InventoryRepository inventoryRepo, ProductBatchRepository productBatchRepo, SalesRepository salesRepo) {
        this.inventoryRepo = inventoryRepo;
        this.productBatchRepo = productBatchRepo;
        this.salesRepo = salesRepo;
    }

    @GetMapping("/totalInventoryCount")
    public Long getTotalInventoryCount() {
        return inventoryRepo.count();
    }

    @GetMapping("/totalProductBatchesCount")
    public Long getTotalProductBatchesCount() {
        return productBatchRepo.count();
    }

    @GetMapping("/totalSalesCount")
    public Long getTotalSalesCount() {
        return salesRepo.count();
    }
}
