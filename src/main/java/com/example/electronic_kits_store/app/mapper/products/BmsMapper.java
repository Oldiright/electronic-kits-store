package com.example.electronic_kits_store.app.mapper.products;

import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.model.Bms;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BmsMapper extends AbstractProductMapper<Bms, BmsDTO, CreateBmsRequest> {

}
