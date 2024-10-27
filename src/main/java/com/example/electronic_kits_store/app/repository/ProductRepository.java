package com.example.electronic_kits_store.app.repository;

import com.example.electronic_kits_store.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
