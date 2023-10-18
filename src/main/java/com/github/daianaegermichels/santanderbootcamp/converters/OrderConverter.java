package com.github.daianaegermichels.santanderbootcamp.converters;

import com.github.daianaegermichels.santanderbootcamp.domain.Order;
import com.github.daianaegermichels.santanderbootcamp.dtos.OrderDTO;

import java.util.stream.Collectors;

public class OrderConverter {
    public static OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setItems(order.getItems().stream().map(CartItemConverter::toDTO).collect(Collectors.toList()));
        orderDTO.setTotal(order.getTotal());
        return orderDTO;
    }

    public static Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setStatus(orderDTO.getStatus());
        order.setItems(orderDTO.getItems().stream().map(CartItemConverter::toEntity).collect(Collectors.toList()));
        order.setTotal(orderDTO.getTotal());
        return order;
    }
}

