package com.github.daianaegermichels.santanderbootcamp.converters;

import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;
import com.github.daianaegermichels.santanderbootcamp.domain.Product;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartItemDTO;

public class CartItemConverter {
    public static CartItemDTO toDTO(CartItem cartItem) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(cartItem.getId());
        cartItemDTO.setProductId(cartItem.getProduct().getId());
        cartItemDTO.setQuantity(cartItem.getQuantity());
        return cartItemDTO;
    }

    public static CartItem toEntity(CartItemDTO cartItemDTO) {
        CartItem cartItem = new CartItem();
        cartItem.setId(cartItemDTO.getId());
        Product product = new Product();
        product.setId(cartItemDTO.getProductId());
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemDTO.getQuantity());
        return cartItem;
    }
}
