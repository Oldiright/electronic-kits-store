package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.Miscellaneous.CreateMiscellaneousRequest;
import com.example.electronic_kits_store.app.dto.Miscellaneous.MiscellaneousDTO;
import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import com.example.electronic_kits_store.app.model.Miscellaneous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MiscellaneousService extends AbstractSpecificProductService<Miscellaneous, MiscellaneousDTO, CreateMiscellaneousRequest>{
    public MiscellaneousService(JpaRepository<Miscellaneous, Long> repository, AbstractMapper<Miscellaneous, MiscellaneousDTO, CreateMiscellaneousRequest> mapper) {
        super(repository, mapper);
    }
}
