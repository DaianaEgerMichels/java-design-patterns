package com.github.daianaegermichels.santanderbootcamp.service;

import com.github.daianaegermichels.santanderbootcamp.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long productId);
}
