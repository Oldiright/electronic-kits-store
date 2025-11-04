package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import com.example.electronic_kits_store.app.mapper.InverterMapper;
import com.example.electronic_kits_store.app.model.Inverter;
import com.example.electronic_kits_store.app.repository.InverterRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InverterService extends AbstractSpecificProductService<Inverter, InverterDTO, CreateInverterRequest, InverterMapper> {
    public InverterService(InverterRepository repository, InverterMapper mapper) {
        super(repository, mapper);
    }
}
