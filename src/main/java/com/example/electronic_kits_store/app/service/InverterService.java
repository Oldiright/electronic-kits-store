package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Inverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InverterService extends AbstractSpecificProductService<Inverter, InverterDTO, CreateInverterRequest> {
    public InverterService(JpaRepository<Inverter, Long> repository, AbstractMapper<Inverter, InverterDTO, CreateInverterRequest> mapper) {
        super(repository, mapper);
    }
}
