package com.pioneers.medmartbck.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pioneers.medmartbck.repository.InventoryRepository;
import com.pioneers.medmartbck.repository.ProductBatchRepository;
import com.pioneers.medmartbck.repository.ProductRepository;
import com.pioneers.medmartbck.repository.SalesRepository;

@RestController
@RequestMapping("api/v1/dashboard")
public class DashboardController {

    private final InventoryRepository inventoryRepo;
    private final ProductBatchRepository productBatchRepo;
    private final SalesRepository salesRepo;
    private final ProductRepository productRepo;

    public DashboardController(InventoryRepository inventoryRepo, ProductBatchRepository productBatchRepo, SalesRepository salesRepo, ProductRepository productRepo) {
        this.inventoryRepo = inventoryRepo;
        this.productBatchRepo = productBatchRepo;
        this.salesRepo = salesRepo;
        this.productRepo = productRepo;
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

    @GetMapping("/totalProductCount")
    public Long getTotalProductCount() {
        return productRepo.count();
    }

    @GetMapping("/salesPerDay")
    public Double getSalesPerDay(@RequestParam("date") String date) {
        LocalDateTime startOfDay = LocalDate.parse(date).atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        return salesRepo.sumBySaleDateBetween(startOfDay, endOfDay);
    }

    @GetMapping("/salesPerWeek")
    public Double getSalesPerWeek(@RequestParam("startDate") String startDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = start.plusWeeks(1);
        LocalDateTime startOfWeek = start.atStartOfDay();
        LocalDateTime endOfWeek = end.atStartOfDay();
        return salesRepo.sumBySaleDateBetween(startOfWeek, endOfWeek);
    }
}
