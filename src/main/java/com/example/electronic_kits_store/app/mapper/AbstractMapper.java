package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.model.Battery;

public interface AbstractMapper<E, D, R> {
    D toDto(E product);

    // pictureUrl не встановлюємо при створенні
//    @Mappings({
//            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "pictureUrl", ignore = true)
//    })
    E toEntity(R request);
}
