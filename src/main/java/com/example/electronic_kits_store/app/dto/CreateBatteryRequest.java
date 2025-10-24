package com.example.electronic_kits_store.app.dto;

import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Product;

import java.math.BigDecimal;

public record CreateBatteryRequest (
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Integer rating,
        Product.Category category,
        Integer nominalVoltage,
        Integer capacity,
        Battery.FormFactor form,
        Integer batteryTerminalDiameter
){}
