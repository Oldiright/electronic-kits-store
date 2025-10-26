package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.model.Inverter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InverterMapper extends AbstractMapper<Inverter, InverterDTO, CreateInverterRequest>{
}
