package com.example.electronic_kits_store.app.service;


import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.model.projection.ProductProjection;
import com.example.electronic_kits_store.app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findAllWithDetails() {
        return productRepository.findAll();
    }
    public List<ProductProjection> findAll() {
        return productRepository.findAllProjectedBy();
    }


}
