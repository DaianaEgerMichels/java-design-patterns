package com.github.daianaegermichels.santanderbootcamp.service.impl;

import com.github.daianaegermichels.santanderbootcamp.domain.Cart;
import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;
import com.github.daianaegermichels.santanderbootcamp.repository.CartRepository;
import com.github.daianaegermichels.santanderbootcamp.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public void addToCart(Cart cart, CartItem cartItem) {
        // logic to add cart items to the cart.
    }

    @Override
    public void removeFromCart(Cart cart, CartItem cartItem) {
        // logic to remove cart items from the cart.
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }
}

