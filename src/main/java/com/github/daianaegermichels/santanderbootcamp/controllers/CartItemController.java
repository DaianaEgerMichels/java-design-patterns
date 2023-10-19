package com.github.daianaegermichels.santanderbootcamp.controllers;

import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartItemDTO;
import com.github.daianaegermichels.santanderbootcamp.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemDTO> getCartItemById(@PathVariable Long cartItemId) {
        CartItemDTO cartItem = cartItemService.getCartItemById(cartItemId);
        return ResponseEntity.ok(cartItem);
    }
}
