package com.github.daianaegermichels.santanderbootcamp.service.impl;

import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;
import com.github.daianaegermichels.santanderbootcamp.repository.CartItemRepository;
import com.github.daianaegermichels.santanderbootcamp.service.CartItemService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem getCartItemById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).orElse(null);
    }
}

