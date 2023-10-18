package com.github.daianaegermichels.santanderbootcamp.service;

import com.github.daianaegermichels.santanderbootcamp.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long orderId);
    void placeOrder(Order order);
}

