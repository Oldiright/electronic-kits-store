package com.example.electronic_kits_store.app.dto.product;

import com.example.electronic_kits_store.app.model.Product;

import java.math.BigDecimal;

public record ProductDTO (
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        Product.Category category
)

{

}
