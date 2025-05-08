package com.InventoryService.InventoryServiceApplication.service;


import com.InventoryService.InventoryServiceApplication.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {


    private final InventoryRepository inventoryRepository;
    public boolean inStock(String skuCode){

        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
