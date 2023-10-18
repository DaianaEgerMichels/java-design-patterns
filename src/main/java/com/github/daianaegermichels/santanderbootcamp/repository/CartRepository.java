package com.github.daianaegermichels.santanderbootcamp.repository;

import com.github.daianaegermichels.santanderbootcamp.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
