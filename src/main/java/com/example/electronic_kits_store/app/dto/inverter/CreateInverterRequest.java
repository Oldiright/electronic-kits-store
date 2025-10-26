package com.example.electronic_kits_store.app.dto.inverter;

import com.example.electronic_kits_store.app.model.Inverter;
import com.example.electronic_kits_store.app.model.Product;

import java.math.BigDecimal;

public record CreateInverterRequest (
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        Product.Category category,
        Integer power,
        Inverter.InputVoltage inputVoltage
){
}
