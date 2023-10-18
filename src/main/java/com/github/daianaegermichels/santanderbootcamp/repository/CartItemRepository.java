package com.github.daianaegermichels.santanderbootcamp.repository;

import com.github.daianaegermichels.santanderbootcamp.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}