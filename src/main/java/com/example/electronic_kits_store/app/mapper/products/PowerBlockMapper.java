package com.example.electronic_kits_store.app.mapper.products;

import com.example.electronic_kits_store.app.dto.powerblock.CreatePowerBlockRequest;
import com.example.electronic_kits_store.app.dto.powerblock.PowerBlockDTO;
import com.example.electronic_kits_store.app.model.PowerBlock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PowerBlockMapper extends AbstractProductMapper<PowerBlock, PowerBlockDTO, CreatePowerBlockRequest> {
}
