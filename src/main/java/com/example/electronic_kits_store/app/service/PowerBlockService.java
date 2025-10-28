package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.powerblock.CreatePowerBlockRequest;
import com.example.electronic_kits_store.app.dto.powerblock.PowerBlockDTO;
import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import com.example.electronic_kits_store.app.model.PowerBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PowerBlockService extends AbstractSpecificProductService<PowerBlock, PowerBlockDTO, CreatePowerBlockRequest>{

    public PowerBlockService(JpaRepository<PowerBlock, Long> repository, AbstractMapper<PowerBlock, PowerBlockDTO, CreatePowerBlockRequest> mapper) {
        super(repository, mapper);
    }
}
