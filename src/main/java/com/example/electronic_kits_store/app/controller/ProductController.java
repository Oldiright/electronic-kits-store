package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.product.ProductDTO;
import com.example.electronic_kits_store.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(productService.findById(id));

    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>>findAll() {
        return ResponseEntity.ok(productService.findAll());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
