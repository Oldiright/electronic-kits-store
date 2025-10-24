package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.BmsDTO;
import com.example.electronic_kits_store.app.dto.CreateBmsRequest;
import com.example.electronic_kits_store.app.model.Bms;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BmsMapper {
    BmsDTO toDto(Bms bms);
    Bms toEntity(CreateBmsRequest createBmsRequest);
}
