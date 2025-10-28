package com.example.electronic_kits_store.app.dto.powerBlock;

import com.example.electronic_kits_store.app.model.Product;

import java.math.BigDecimal;

public record CreatePowerBlockRequest(
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        Product.Category category,
        Integer minVoltage,
        Integer maxVoltage,
        Integer power
) {
}
