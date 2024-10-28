package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.model.projection.ProductProjection;
import com.example.electronic_kits_store.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class TestController {
    private final ProductService productService;

    @GetMapping("/all")
    public Object findAllWithDetails(@RequestParam boolean details) {
        if (details) {
            return productService.findAllWithDetails();
        }
        return productService.findAll();
    }
    @GetMapping("/manufacturer/{manufacturer}")
    public Object findAllWithDetails(@PathVariable String manufacturer) {
       return productService.findByManufacturer(manufacturer);
    }

    @GetMapping("/category/{category}")
    public List<ProductProjection> findByCategory(@PathVariable String category) {
        return productService.findByCategory(Product.Category.valueOf(category.toUpperCase()));
    }


}
