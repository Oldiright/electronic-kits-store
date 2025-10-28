package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.wirelug.CreateWireLugRequest;
import com.example.electronic_kits_store.app.dto.wirelug.WireLugDTO;
import com.example.electronic_kits_store.app.model.WireLug;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WireLugMapper extends AbstractMapper<WireLug, WireLugDTO, CreateWireLugRequest>{
}
