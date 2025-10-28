package com.example.electronic_kits_store.app.dto.wirelug;

import java.math.BigDecimal;

public record WireLugDTO(
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        String category,
        Integer wireCrossSectionArea,
        Integer terminalDiameter,
        String material
) {

}
