package com.InventoryService.InventoryServiceApplication;

import com.InventoryService.InventoryServiceApplication.model.Inventory;
import com.InventoryService.InventoryServiceApplication.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory1 = Inventory.builder().skuCode("Iphone13").quantity(1).build();
            Inventory inventory2 = Inventory.builder().skuCode("Iphone13 pro max").quantity(0).build();

            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };


    }*/

}
