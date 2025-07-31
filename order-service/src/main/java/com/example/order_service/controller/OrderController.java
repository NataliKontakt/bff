package com.example.order_service.controller;

import com.example.contracts.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders/by-user")
public class OrderController {
    private static final Map<Long, Order> ORDER_DATA = Map.of(
            1L, new Order(1001L, 1L, 1500.0, "RUB", List.of("Скатерть", "Стаканы")),
            2L, new Order(2001L, 2L, 3000.0, "USD", List.of("Монитор", "Ноутбук", "Клавиатура"))
    );
    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable("userId") Long userId) {
        List<Order> orders = ORDER_DATA.values().stream()
                .filter(order -> order.getUserId().equals(userId))
                .collect(Collectors.toList());

        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orders);
    }
}
