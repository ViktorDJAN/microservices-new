package ru.kashtanov.inventory.service;

import org.springframework.stereotype.Service;
import ru.kashtanov.inventory.model.Inventory;
import ru.kashtanov.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public boolean isInStock(String skuCode){
     return inventoryRepository.findAnswerBySkuCode(skuCode).isPresent();
    }
}
