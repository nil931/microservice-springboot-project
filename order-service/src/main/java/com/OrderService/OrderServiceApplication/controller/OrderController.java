package com.OrderService.OrderServiceApplication.controller;

import com.OrderService.OrderServiceApplication.dto.OrderRequest;
import com.OrderService.OrderServiceApplication.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderService")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {

        return orderService.placeOrder(orderRequest);
    }
}
