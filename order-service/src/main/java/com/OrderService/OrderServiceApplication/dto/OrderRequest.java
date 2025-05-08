package com.OrderService.OrderServiceApplication.dto;

import com.OrderService.OrderServiceApplication.model.OrderLineItems;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private BigDecimal total;
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
