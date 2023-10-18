package com.github.daianaegermichels.santanderbootcamp.service.impl;

import com.github.daianaegermichels.santanderbootcamp.domain.Order;
import com.github.daianaegermichels.santanderbootcamp.repository.OrderRepository;
import com.github.daianaegermichels.santanderbootcamp.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public void placeOrder(Order order) {
        // logic to place an order.
    }
}

