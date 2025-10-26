package com.example.electronic_kits_store.app.dto.battery;

import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Product;

import java.math.BigDecimal;

public record BatteryDTO(
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        Product.Category category,
        Integer nominalVoltage,
        Integer capacity,
        Battery.FormFactor form,
        Integer batteryTerminalDiameter
) { }
