package com.github.daianaegermichels.santanderbootcamp.controllers;

import com.github.daianaegermichels.santanderbootcamp.dtos.CartDTO;
import com.github.daianaegermichels.santanderbootcamp.dtos.CartItemDTO;
import com.github.daianaegermichels.santanderbootcamp.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long cartId) {
        CartDTO cart = cartService.getCartById(cartId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addToCart(@RequestBody CartDTO cart, @RequestBody CartItemDTO cartItem) {
        cartService.addToCart(cart, cartItem);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeFromCart(@RequestBody CartDTO cart, @RequestBody CartItemDTO cartItem) {
        cartService.removeFromCart(cart, cartItem);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateCart(@RequestBody CartDTO cartDTO) {
        cartService.updateCart(cartDTO);
        return ResponseEntity.noContent().build();
    }
}
