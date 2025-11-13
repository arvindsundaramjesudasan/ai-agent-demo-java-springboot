package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "Order Management", description = "APIs for managing orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "Get all orders", description = "Retrieve a list of all orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID", description = "Retrieve a specific order by its ID")
    public ResponseEntity<Order> getOrderById(
            @Parameter(description = "Order ID") @PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Get orders by status", description = "Retrieve orders filtered by status")
    public ResponseEntity<List<Order>> getOrdersByStatus(
            @Parameter(description = "Order status") @PathVariable String status) {
        return ResponseEntity.ok(orderService.getOrdersByStatus(status));
    }

    @GetMapping("/customer/{customerName}")
    @Operation(summary = "Get orders by customer name", description = "Retrieve orders filtered by customer name")
    public ResponseEntity<List<Order>> getOrdersByCustomerName(
            @Parameter(description = "Customer name") @PathVariable String customerName) {
        return ResponseEntity.ok(orderService.getOrdersByCustomerName(customerName));
    }

    @PostMapping
    @Operation(summary = "Create a new order", description = "Create a new order in the system")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an order", description = "Update an existing order by its ID")
    public ResponseEntity<Order> updateOrder(
            @Parameter(description = "Order ID") @PathVariable Long id,
            @RequestBody Order orderDetails) {
        return orderService.updateOrder(id, orderDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an order", description = "Delete an order by its ID")
    public ResponseEntity<Void> deleteOrder(
            @Parameter(description = "Order ID") @PathVariable Long id) {
        return orderService.deleteOrder(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
