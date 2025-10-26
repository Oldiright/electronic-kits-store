package com.example.electronic_kits_store.app.dto.Miscellaneous;

import com.example.electronic_kits_store.app.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public record MiscellaneousDTO (
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        Product.Category category,
        Map<String, String> otherInfo
){
}
