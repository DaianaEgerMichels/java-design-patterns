package com.github.daianaegermichels.santanderbootcamp.service.impl;

import com.github.daianaegermichels.santanderbootcamp.domain.Product;
import com.github.daianaegermichels.santanderbootcamp.repository.ProductRepository;
import com.github.daianaegermichels.santanderbootcamp.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product saveProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            throw new IllegalArgumentException("This product Id already exists.");
        }
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

