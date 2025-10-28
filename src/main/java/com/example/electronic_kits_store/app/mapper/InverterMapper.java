package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.model.Inverter;
import org.mapstruct.Mapper;

import java.util.Arrays;

@Mapper(componentModel = "spring")
public interface InverterMapper extends AbstractMapper<Inverter, InverterDTO, CreateInverterRequest>{
    default Inverter.InputVoltage convertInputVoltage(String value) {
        if (value == null) {
            return null; // Обробка null-значення
        }
        // Шукаємо константу Enum, toString() якої відповідає вхідному значенню
        return Arrays.stream(Inverter.InputVoltage.values())
                .filter(v -> v.toString().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Невідома вхідна напруга: " + value));
    }
    default String convertInputVoltage(Inverter.InputVoltage inputVoltage) {
        if (inputVoltage == null) {
            return null; // Обробка null-значення
        }
        return inputVoltage.toString();
    }
}
