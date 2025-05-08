package com.InventoryService.InventoryServiceApplication.controller;

import com.InventoryService.InventoryServiceApplication.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventoryService")
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping("/isInStock/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public String isInStock(@PathVariable String skuCode) {

        if (inventoryService.inStock(skuCode)) {
            return skuCode + " is in Stock!!";
        }
        return skuCode + " is not available in stock at the moment!!";
    }
}
