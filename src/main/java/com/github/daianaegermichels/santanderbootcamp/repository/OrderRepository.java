package com.github.daianaegermichels.santanderbootcamp.repository;

import com.github.daianaegermichels.santanderbootcamp.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}