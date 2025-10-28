package com.example.electronic_kits_store.app.dto.wire;

import java.math.BigDecimal;

public record WireDTO(
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        String category,
        String color,
        Integer crossSectionArea,
        String insulationMaterial
) {}
