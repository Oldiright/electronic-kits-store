package com.example.electronic_kits_store.app.dto.Miscellaneous;


import java.math.BigDecimal;
import java.util.Map;

public record MiscellaneousDTO (
        Long id,
        String name,
        BigDecimal cost,
        String manufacturer,
        String description,
        Byte rating,
        String pictureUrl,
        String category,
        Map<String, String> otherInfo
){
}
