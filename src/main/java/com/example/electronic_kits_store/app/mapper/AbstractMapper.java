package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Product;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface AbstractMapper<E, D, R> {

    D toDto(E product);

    // pictureUrl не встановлюємо при створенні
//    @Mappings({
////            @Mapping(target = "id", ignore = true),
////            @Mapping(target = "pictureUrl", ignore = true),
////            @Mapping(target = "category", ignore = true)
//    })
    E toEntity(R request);

}
