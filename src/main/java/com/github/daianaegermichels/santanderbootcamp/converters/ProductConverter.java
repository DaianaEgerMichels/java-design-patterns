package com.github.daianaegermichels.santanderbootcamp.converters;

import com.github.daianaegermichels.santanderbootcamp.domain.Product;
import com.github.daianaegermichels.santanderbootcamp.dtos.ProductDTO;

public class ProductConverter {
    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        productDTO.setCategory(product.getCategory());
        productDTO.setManufacturer(product.getManufacturer());
        productDTO.setImages(product.getImages());
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setCategory(productDTO.getCategory());
        product.setManufacturer(productDTO.getManufacturer());
        product.setImages(productDTO.getImages());
        return product;
    }
}
