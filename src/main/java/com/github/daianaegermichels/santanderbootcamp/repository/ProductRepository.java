package com.github.daianaegermichels.santanderbootcamp.repository;

import com.github.daianaegermichels.santanderbootcamp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
