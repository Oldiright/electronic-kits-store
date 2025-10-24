package com.example.electronic_kits_store.app.repository;

import com.example.electronic_kits_store.app.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findProductsBySubtype(Class<? extends Product> subtype);
}
