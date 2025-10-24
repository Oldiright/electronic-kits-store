package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.BatteryDTO;
import com.example.electronic_kits_store.app.dto.CreateBatteryRequest;
import com.example.electronic_kits_store.app.model.Battery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface BatteryMapper {

//    @Mappings({
//            @Mapping(target = "id", source = "id"),
//            @Mapping(target = "name", source = "name"),
//            @Mapping(target = "cost", source = "cost"),
//            @Mapping(target = "manufacturer", source = "manufacturer"),
//            @Mapping(target = "description", source = "description"),
//            @Mapping(target = "rating", source = "rating"),
//            @Mapping(target = "pictureUrl", source = "pictureUrl"),
//            @Mapping(target = "category", source = "category"),
//            @Mapping(target = "nominalVoltage", source = "nominalVoltage"),
//            @Mapping(target = "capacity", source = "capacity"),
//            @Mapping(target = "form", source = "form"),
//            @Mapping(target = "batteryTerminalDiameter", source = "batteryTerminalDiameter")
//    })
    BatteryDTO toDto(Battery battery);

    // pictureUrl не встановлюємо при створенні
//    @Mappings({
//            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "pictureUrl", ignore = true)
//    })
    Battery toEntity(CreateBatteryRequest request);
}
