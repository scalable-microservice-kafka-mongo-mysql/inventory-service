package com.ashutoshpathak.inventoryservice.service;

import com.ashutoshpathak.inventoryservice.Repository.InventoryRepository;
import model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer orderQuantity){

        Optional<Inventory> byskuCode = inventoryRepository.findByskuCode(skuCode);
        return byskuCode.isPresent() && byskuCode.get().getQuantity() >= orderQuantity;

    }
}
