package ru.kashtanov.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kashtanov.inventory.model.Inventory;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    @Query("SELECT i FROM Inventory i WHERE i.skuCode =?1")
    Optional<Inventory> findAnswerBySkuCode(String skuCode);
}
