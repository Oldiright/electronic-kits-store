package com.example.electronic_kits_store.app.dto.bms;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateBmsRequest (
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
        @NotNull @Positive
        Integer maxPower,
        @NotNull
        @Pattern(regexp = "^(ACTIVE|PASSIVE)$", message = "Тип балансиру має бути 'ACTIVE' або 'PASSIVE'")
        String balancerType,
        //todo add validation (minStringSupported < maxStringSupported)
        @NotNull @Positive
        Integer minStringSupported,
        @NotNull @Positive
        Integer maxStringSupported,
        @NotNull
        Boolean isBluetooth
){
}
