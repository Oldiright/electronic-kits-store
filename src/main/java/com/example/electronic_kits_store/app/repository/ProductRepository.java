package com.example.electronic_kits_store.app.repository;

import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.model.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    List<ProductProjection> findAllProjectedBy();
    List<ProductProjection> findAllProjectedByManufacturer(String manufacturer);
    List<ProductProjection> findAllProjectedByProductCategory(Product.Category category);
    List<Product> findAlByProductCategory(Product.Category category);
}
