package com.InventoryService.InventoryServiceApplication.service;


import com.InventoryService.InventoryServiceApplication.dto.InventoryResponse;
import com.InventoryService.InventoryServiceApplication.model.Inventory;
import com.InventoryService.InventoryServiceApplication.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {


    private final InventoryRepository inventoryRepository;

    /* public boolean inStock(String skuCode){

         return inventoryRepository.findBySkuCode(skuCode).isPresent();
     }*/
    public List<InventoryResponse> inStock(List<String> skuCodes) {

        List<Inventory> inventories = inventoryRepository.findBySkuCodeIn(skuCodes);

        return skuCodes.stream().map(sku -> {
            boolean inStock = inventories.stream().anyMatch(inv -> sku.equals(inv.getSkuCode()) && inv.getQuantity() > 0);

            return InventoryResponse.builder().skuCodes(sku).isInStock(inStock).
                    build();
        }).collect(Collectors.toList());

    }

}
