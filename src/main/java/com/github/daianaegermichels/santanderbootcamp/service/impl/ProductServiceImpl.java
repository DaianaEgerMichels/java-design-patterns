package com.github.daianaegermichels.santanderbootcamp.service.impl;

import com.github.daianaegermichels.santanderbootcamp.converters.ProductConverter;
import com.github.daianaegermichels.santanderbootcamp.domain.Product;
import com.github.daianaegermichels.santanderbootcamp.dtos.ProductDTO;
import com.github.daianaegermichels.santanderbootcamp.repository.ProductRepository;
import com.github.daianaegermichels.santanderbootcamp.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        try{
            List<Product> products = productRepository.findAll();
            List<ProductDTO> productDTOs = products.stream()
                    .map(ProductConverter::toDTO)
                    .collect(Collectors.toList());
            return productDTOs;
        } catch (Exception e) {
            throw new RuntimeException("Error getting all products: " + e.getMessage(), e);
        }
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(NoSuchElementException::new);

        return ProductConverter.toDTO(product);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = ProductConverter.toEntity(productDTO);
        if (productRepository.existsById(product.getId())) {
            throw new IllegalArgumentException("This product Id already exists.");
        }

        Product savedProduct = productRepository.save(product);
        return ProductConverter.toDTO(savedProduct);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {

        Long productId = productDTO.getId();
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setStock(productDTO.getStock());
        existingProduct.setCategory(productDTO.getCategory());
        existingProduct.setManufacturer(productDTO.getManufacturer());
        existingProduct.setImages(productDTO.getImages());

        productRepository.save(existingProduct);

    }

    @Override
    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new NoSuchElementException("Product not found");
        }

        productRepository.deleteById(productId);
    }
}

