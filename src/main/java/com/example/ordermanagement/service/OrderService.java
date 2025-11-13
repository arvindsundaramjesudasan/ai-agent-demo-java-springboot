package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Transactional(readOnly = true)
    public List<Order> getOrdersByCustomerName(String customerName) {
        return orderRepository.findByCustomerName(customerName);
    }

    @Transactional
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Optional<Order> updateOrder(Long id, Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setCustomerName(orderDetails.getCustomerName());
                    order.setProductName(orderDetails.getProductName());
                    order.setQuantity(orderDetails.getQuantity());
                    order.setPrice(orderDetails.getPrice());
                    order.setStatus(orderDetails.getStatus());
                    return orderRepository.save(order);
                });
    }

    @Transactional
    public boolean deleteOrder(Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    orderRepository.delete(order);
                    return true;
                })
                .orElse(false);
    }
}
