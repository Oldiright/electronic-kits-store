package com.example.electronic_kits_store.app.repository;

import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    Page<ProductProjection> findAllProjectedBy(Pageable pageable);
    ProductProjection findProjectedById(long id);
    List<ProductProjection> findAllProjectedByManufacturer(String manufacturer);
    List<ProductProjection> findAllProjectedByCategory(Product.Category category);
    List<Product> findAlByCategory(Product.Category category);
}
