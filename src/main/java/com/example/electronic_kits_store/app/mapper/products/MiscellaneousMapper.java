package com.example.electronic_kits_store.app.mapper.products;

import com.example.electronic_kits_store.app.dto.miscellaneous.CreateMiscellaneousRequest;
import com.example.electronic_kits_store.app.dto.miscellaneous.MiscellaneousDTO;
import com.example.electronic_kits_store.app.model.Miscellaneous;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MiscellaneousMapper extends AbstractProductMapper<Miscellaneous, MiscellaneousDTO, CreateMiscellaneousRequest> {
}
