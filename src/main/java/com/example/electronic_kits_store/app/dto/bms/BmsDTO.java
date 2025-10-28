package com.example.electronic_kits_store.app.dto.bms;


import java.math.BigDecimal;

public record BmsDTO (
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        String category,
        Integer maxPower,
        String balancerType,
        Integer minStringSupported,
        Integer maxStringSupported,
        Boolean isBluetooth
) {
}
