package com.github.daianaegermichels.santanderbootcamp.service.impl;

import com.github.daianaegermichels.santanderbootcamp.converters.CartItemConverter;
import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartItemDTO;
import com.github.daianaegermichels.santanderbootcamp.repository.CartItemRepository;
import com.github.daianaegermichels.santanderbootcamp.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItemDTO getCartItemById(Long cartItemId) {
        try {
            if (cartItemId == null || cartItemId <= 0) {
                throw new IllegalArgumentException("Invalid cart item ID.");
            }

            Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
            if (cartItemOptional.isPresent()) {
                CartItem cartItem = cartItemOptional.get();
                return CartItemConverter.toDTO(cartItem);
            } else {
                throw new NoSuchElementException("Cart item not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting the cart item: " + e.getMessage(), e);
        }
    }

}

