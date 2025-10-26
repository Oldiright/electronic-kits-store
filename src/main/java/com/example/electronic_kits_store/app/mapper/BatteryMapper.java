package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.model.Battery;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BatteryMapper extends AbstractMapper<Battery, BatteryDTO, CreateBatteryRequest> {

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
//    BatteryDTO toDto(Battery battery);

    // pictureUrl не встановлюємо при створенні
//    @Mappings({
//            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "pictureUrl", ignore = true)
//    })
//    Battery toEntity(CreateBatteryRequest request);
}
