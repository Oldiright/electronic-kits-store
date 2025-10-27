package com.example.electronic_kits_store.app.dto.bms;

import com.example.electronic_kits_store.app.model.Bms;
import com.example.electronic_kits_store.app.model.Product;

import java.math.BigDecimal;

public record CreateBmsRequest (
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        Product.Category category,
        Integer maxPower,
        Bms.Balancer balancerType,
        Integer minStringSupported,
        Integer maxStringSupported,
        Boolean isBluetooth
){
}
