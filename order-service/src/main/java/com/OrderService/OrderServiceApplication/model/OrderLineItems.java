package com.OrderService.OrderServiceApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "orderLineItemsTable")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private String skuCode;
    private String item;
    private Integer quantity;
}
