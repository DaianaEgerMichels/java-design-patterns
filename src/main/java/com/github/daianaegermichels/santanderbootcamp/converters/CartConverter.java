package com.github.daianaegermichels.santanderbootcamp.converters;

import com.github.daianaegermichels.santanderbootcamp.domain.Cart;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartDTO;

import java.util.stream.Collectors;

public class CartConverter {
    public static CartDTO toDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setItems(cart.getItems().stream().map(CartItemConverter::toDTO).collect(Collectors.toList()));
        cartDTO.setTotal(cart.getTotal());
        return cartDTO;
    }

    public static Cart toEntity(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        cart.setItems(cartDTO.getItems().stream().map(CartItemConverter::toEntity).collect(Collectors.toList()));
        cart.setTotal(cartDTO.getTotal());
        return cart;
    }
}

