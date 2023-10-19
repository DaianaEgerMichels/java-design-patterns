package com.github.daianaegermichels.santanderbootcamp.service.impl;

import com.github.daianaegermichels.santanderbootcamp.converters.OrderConverter;
import com.github.daianaegermichels.santanderbootcamp.domain.Order;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartItemDTO;
import com.github.daianaegermichels.santanderbootcamp.dtos.OrderDTO;
import com.github.daianaegermichels.santanderbootcamp.repository.OrderRepository;
import com.github.daianaegermichels.santanderbootcamp.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        try {
            List<Order> orders = orderRepository.findAll();
            List<OrderDTO> orderDTOs = orders.stream()
                    .map(OrderConverter::toDTO)
                    .collect(Collectors.toList());
            return orderDTOs;
        } catch (Exception e) {
            throw new RuntimeException("Error getting all orders: " + e.getMessage(), e);
        }
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        try {
            if (orderId == null || orderId <= 0) {
                throw new IllegalArgumentException("Invalid order ID.");
            }

            Optional<Order> orderOptional = orderRepository.findById(orderId);
            if (orderOptional.isPresent()) {
                Order order = orderOptional.get();
                return OrderConverter.toDTO(order);
            } else {
                throw new NoSuchElementException("Order not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting the order: " + e.getMessage(), e);
        }
    }

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        try {
            if (orderDTO.getId() != null) {
                throw new IllegalArgumentException("Order ID should be null for a new order.");
            }

            List<CartItemDTO> items = orderDTO.getItems();
            if (items == null || items.isEmpty()) {
                throw new IllegalArgumentException("Order should have at least one item.");
            }

            Order order = OrderConverter.toEntity(orderDTO);
            var orderSaved = orderRepository.save(order);
            return OrderConverter.toDTO(orderSaved);
        } catch (Exception e) {
            throw new RuntimeException("Error placing the order: " + e.getMessage(), e);
        }
    }
}

