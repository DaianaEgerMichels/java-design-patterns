package com.github.daianaegermichels.santanderbootcamp.service;

import com.github.daianaegermichels.santanderbootcamp.domain.Cart;
import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;

public interface CartService {
    Cart getCartById(Long cartId);
    void addToCart(Cart cart, CartItem cartItem);
    void removeFromCart(Cart cart, CartItem cartItem);
    void updateCart(Cart cart);
}
