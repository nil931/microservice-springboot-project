package com.OrderService.OrderServiceApplication.repository;

import com.OrderService.OrderServiceApplication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
