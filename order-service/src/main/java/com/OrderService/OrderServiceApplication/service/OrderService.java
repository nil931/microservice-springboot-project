package com.OrderService.OrderServiceApplication.service;

import com.OrderService.OrderServiceApplication.dto.OrderLineItemsDto;
import com.OrderService.OrderServiceApplication.dto.OrderRequest;
import com.OrderService.OrderServiceApplication.model.Order;
import com.OrderService.OrderServiceApplication.model.OrderLineItems;
import com.OrderService.OrderServiceApplication.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {


        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(orderLineItemsList)
                .total(orderRequest.getTotal())
                .build();

        orderRepository.save(order);


    }

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems orderLineItems = OrderLineItems.builder()
                .item(orderLineItemsDto.getItem())
                .quantity(orderLineItemsDto.getQuantity())
                .skuCode(orderLineItemsDto.getSkuCode())
                .price(orderLineItemsDto.getPrice())
                .build();

        return orderLineItems;

    }

}
