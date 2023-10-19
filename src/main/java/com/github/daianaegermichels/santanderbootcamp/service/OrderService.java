package com.github.daianaegermichels.santanderbootcamp.service;

import com.github.daianaegermichels.santanderbootcamp.dtos.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long orderId);
    OrderDTO placeOrder(OrderDTO order);
}

