package com.github.daianaegermichels.santanderbootcamp.service.impl;

import com.github.daianaegermichels.santanderbootcamp.converters.CartConverter;
import com.github.daianaegermichels.santanderbootcamp.converters.CartItemConverter;
import com.github.daianaegermichels.santanderbootcamp.domain.Cart;
import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartDTO;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartItemDTO;
import com.github.daianaegermichels.santanderbootcamp.repository.CartRepository;
import com.github.daianaegermichels.santanderbootcamp.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartDTO getCartById(Long cartId) {
        try {
            if (cartId == null || cartId <= 0) {
                throw new IllegalArgumentException("Invalid cart ID.");
            }

            Optional<Cart> cartOptional = cartRepository.findById(cartId);
            if (cartOptional.isPresent()) {
                Cart cart = cartOptional.get();
                return CartConverter.toDTO(cart);
            } else {
                throw new NoSuchElementException("Cart not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting the cart: " + e.getMessage(), e);
        }
    }


    @Override
    public void addToCart(CartDTO cart, CartItemDTO cartItem) {
        try {
            if (cart == null || cartItem == null) {
                throw new IllegalArgumentException("Cart or cart item is null.");
            }

            if (cart.getItems() == null) {
                cart.setItems(new ArrayList<>());
            }

            // Find if the product is already in the cart; if found, update the quantity.
            CartItemDTO existingCartItem = cart.getItems().stream()
                    .filter(item -> item.getProductId().equals(cartItem.getProductId()))
                    .findFirst()
                    .orElse(null);

            if (existingCartItem != null) {
                // Update the quantity.
                existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
            } else {
                cart.getItems().add(cartItem);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error adding to the cart: " + e.getMessage(), e);
        }
    }


    @Override
    public void removeFromCart(CartDTO cart, CartItemDTO cartItem) {
        try {
            if (cart == null || cartItem == null) {
                throw new IllegalArgumentException("Cart or cart item is null.");
            }

            if (cart.getItems() == null) {
                return;
            }

            cart.getItems().removeIf(item -> item.getProductId().equals(cartItem.getProductId()));
        } catch (Exception e) {
            throw new RuntimeException("Error removing from the cart: " + e.getMessage(), e);
        }
    }


    @Override
    public void updateCart(CartDTO cartDTO) {
        try {
            if (cartDTO == null || cartDTO.getId() == null) {
                throw new IllegalArgumentException("Invalid cart DTO or cart ID is null.");
            }

            Optional<Cart> cartOptional = cartRepository.findById(cartDTO.getId());
            if (cartOptional.isPresent()) {
                Cart cart = cartOptional.get();

                List<CartItem> cartItems = cartDTO.getItems().stream()
                        .map(itemDTO -> {
                            CartItem cartItem = CartItemConverter.toEntity(itemDTO);
                            return cartItem;
                        })
                        .collect(Collectors.toList());

                cart.setItems(cartItems);
                cart.setTotal(cartDTO.getTotal());

                cartRepository.save(cart);
            } else {
                throw new NoSuchElementException("Cart not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating the cart: " + e.getMessage(), e);
        }
    }

}

