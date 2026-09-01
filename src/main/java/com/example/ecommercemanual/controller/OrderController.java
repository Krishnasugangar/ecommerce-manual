
package com.example.ecommercemanual.controller;

import com.example.ecommercemanual.entity.Order;
import com.example.ecommercemanual.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 1. CREATE: Process a new checkout (Place an order)
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // Automatically stamp the order with the exact current time if the frontend didn't send one
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDateTime.now());
        }
        
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    // 2. READ: Fetch the order history for a specific customer
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }
}
