package com.example.electronic_kits_store.app.dto.powerBlock;

import java.math.BigDecimal;

public record PowerBlockDTO(
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        String category,
        Integer minVoltage,
        Integer maxVoltage,
        Integer power
) {
}
