package com.github.daianaegermichels.santanderbootcamp.service;

import com.github.daianaegermichels.santanderbootcamp.dtos.CartDTO;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartItemDTO;

public interface CartService {
    CartDTO getCartById(Long cartId);
    void addToCart(CartDTO cart, CartItemDTO cartItem);
    void removeFromCart(CartDTO cart, CartItemDTO cartItem);
    void updateCart(CartDTO cart);
}
