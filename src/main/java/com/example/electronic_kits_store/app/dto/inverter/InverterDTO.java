package com.example.electronic_kits_store.app.dto.inverter;

import java.math.BigDecimal;

public record InverterDTO (
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        String category,
        Integer power,
        String inputVoltage
){
}
