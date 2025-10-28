package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.wire.CreateWireRequest;
import com.example.electronic_kits_store.app.dto.wire.WireDTO;
import com.example.electronic_kits_store.app.model.Wire;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface WireMapper extends AbstractMapper<Wire, WireDTO, CreateWireRequest>{
}
