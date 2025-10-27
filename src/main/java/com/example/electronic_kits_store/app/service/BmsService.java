package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import com.example.electronic_kits_store.app.model.Bms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BmsService extends AbstractSpecificProductService<Bms, BmsDTO, CreateBmsRequest> {
    public BmsService(JpaRepository<Bms, Long> repository, AbstractMapper<Bms, BmsDTO, CreateBmsRequest> mapper) {
        super(repository, mapper);
    }
}
