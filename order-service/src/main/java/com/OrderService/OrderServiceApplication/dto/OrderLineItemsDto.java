package com.OrderService.OrderServiceApplication.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {

    private BigDecimal price;
    private String skuCode;
    private String item;
    private Integer quantity;
}
