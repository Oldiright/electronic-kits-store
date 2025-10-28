package com.example.electronic_kits_store.app.dto.wire;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateWireRequest(
        @NotBlank(message = "Назва не може бути порожньою")
        String name,
        @NotNull(message = "Вартість має бути вказана")
        @DecimalMin(value = "0.0", inclusive = false, message = "Вартість повинна бути більшою за 0")
        BigDecimal cost,
        @NotBlank(message = "Виробник обов’язковий")
        String manufacturer,
        @Size(max = 1000, message = "Опис занадто довгий")
        String description,
        @Min(value = 0) @Max(value = 5)
        Byte rating,
        @NotBlank
        String color,
        @NotNull
        Integer crossSectionArea,
        @NotBlank
        String insulationMaterial
) {}
