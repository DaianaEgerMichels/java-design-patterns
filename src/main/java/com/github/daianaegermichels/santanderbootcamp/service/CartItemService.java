package com.github.daianaegermichels.santanderbootcamp.service;

import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;

public interface CartItemService {
    CartItem getCartItemById(Long cartItemId);
}

