package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.Miscellaneous.CreateMiscellaneousRequest;
import com.example.electronic_kits_store.app.dto.Miscellaneous.MiscellaneousDTO;
import com.example.electronic_kits_store.app.model.Miscellaneous;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MiscellaneousMapper extends AbstractMapper<Miscellaneous, MiscellaneousDTO, CreateMiscellaneousRequest>{
}
