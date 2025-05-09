package com.InventoryService.InventoryServiceApplication.controller;

import com.InventoryService.InventoryServiceApplication.dto.InventoryResponse;
import com.InventoryService.InventoryServiceApplication.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventoryService")
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping("/isInStock")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam(name = "skuCode") List<String> skuCodes) {

       return inventoryService.inStock(skuCodes);
    }
}
