package ru.kashtanov.inventory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.kashtanov.inventory.service.InventoryService;

@RestController
@RequestMapping("/api/v3/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public boolean isInStock(@PathVariable("sku-code")String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
