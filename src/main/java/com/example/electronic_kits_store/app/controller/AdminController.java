package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ProductService productService;
    private final ObjectMapper objectMapper;


    @PostMapping("/create/{category}")
    @ResponseBody
    public ResponseEntity<Product> create(@RequestBody String product, @PathVariable String category) throws JsonProcessingException, ClassNotFoundException {
        return new ResponseEntity<>(productService.create(objectMapper.readValue(product, getProductClassName(category))), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }

    private Class<? extends Product> getProductClassName (String category) throws ClassNotFoundException {
        char[] categoryCharArray = category.toCharArray();
        categoryCharArray[0] = Character.toUpperCase(categoryCharArray[0]);
        return Class.forName("com.example.electronic_kits_store.app.model." + String.valueOf(categoryCharArray))
                .asSubclass(Product.class);
    }



}
