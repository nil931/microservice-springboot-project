package com.OrderService.OrderServiceApplication.service;

import com.OrderService.OrderServiceApplication.dto.InventoryResponse;
import com.OrderService.OrderServiceApplication.dto.OrderLineItemsDto;
import com.OrderService.OrderServiceApplication.dto.OrderRequest;
import com.OrderService.OrderServiceApplication.model.Order;
import com.OrderService.OrderServiceApplication.model.OrderLineItems;
import com.OrderService.OrderServiceApplication.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.IClassFileProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final WebClient.Builder webClient;

    public String placeOrder(OrderRequest orderRequest) {


        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(orderLineItemsList)
                .total(orderRequest.getTotal())
                .build();

        List<String> skuCodes = order.getOrderLineItemsList().
                stream().
                map(OrderLineItems::getSkuCode).
                collect(Collectors.toList());

        InventoryResponse[] inventoryResponses = webClient.build().get().
                uri("http://localhost:8082/inventoryService/isInStock",
                        uriBuilder ->
                                uriBuilder.queryParam("skuCode", skuCodes).build()).
                retrieve().bodyToMono(InventoryResponse[].class).block();

        boolean isInStock = Arrays.stream(inventoryResponses).
                allMatch(InventoryResponse::isInStock);

        if (isInStock) {
            orderRepository.save(order);
            return "Order Placed Sucessfully!!";
        } else {
            throw new IllegalArgumentException("Stock is Not available!!");
        }


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
