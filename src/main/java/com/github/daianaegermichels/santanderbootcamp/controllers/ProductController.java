package com.github.daianaegermichels.santanderbootcamp.controllers;

import com.github.daianaegermichels.santanderbootcamp.domain.Product;
import com.github.daianaegermichels.santanderbootcamp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity findAllProducts(Product product) {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Product product) {
        var productCreated = productService.saveProduct(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(productCreated);
    }
}
