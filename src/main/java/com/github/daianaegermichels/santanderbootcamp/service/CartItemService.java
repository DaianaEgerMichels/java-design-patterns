package com.github.daianaegermichels.santanderbootcamp.service;

import com.github.daianaegermichels.santanderbootcamp.dtos.CartItemDTO;

public interface CartItemService {
    CartItemDTO getCartItemById(Long cartItemId);
}

