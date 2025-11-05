package com.example.electronic_kits_store.app.dto.bms;

import com.example.electronic_kits_store.app.validation.ValidRange;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
@ValidRange(minField = "minStringSupported", maxField = "maxStringSupported",
        message = "minStringSupported має бути менше за maxStringSupported")

public record UpdateBmsRequest(
        @NotNull(message = "Id is necessary!")
        Long id,
        @Size(min = 1, message = "Назва не може бути порожньою")
        String name,
        @DecimalMin(value = "0.0", inclusive = false, message = "Вартість повинна бути більшою за 0")
        BigDecimal cost,

        @Size(min = 1, message = "Виробник не може бути порожнім")
        String manufacturer,

        @Size(max = 1000, message = "Опис занадто довгий")
        String description,

        @Min(value = 0, message = "Рейтинг не може бути менше 0")
        @Max(value = 5, message = "Рейтинг не може бути більше 5")
        Byte rating,

        @Positive(message = "Номінальна напруга повинна бути більшою за 0")
        Integer nominalVoltage,
        @Positive(message = "Номінальна потужність повинна бути більшою за 0")
        Integer maxPower,
        String balancerType,
        @Positive
        Integer minStringSupported,
        @Positive
        Integer maxStringSupported,
        Boolean isBluetooth
){
}
