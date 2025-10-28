package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.powerBlock.CreatePowerBlockRequest;
import com.example.electronic_kits_store.app.dto.powerBlock.PowerBlockDTO;
import com.example.electronic_kits_store.app.model.PowerBlock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PowerBlockMapper extends AbstractMapper<PowerBlock, PowerBlockDTO, CreatePowerBlockRequest>{
}
