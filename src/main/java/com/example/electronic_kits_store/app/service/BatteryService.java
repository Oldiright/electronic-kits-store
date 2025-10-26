package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import com.example.electronic_kits_store.app.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;



@Service
public class BatteryService extends AbstractSpecificProductService<Battery, BatteryDTO, CreateBatteryRequest> {

    public BatteryService(JpaRepository<Battery, Long> repository, AbstractMapper<Battery, BatteryDTO, CreateBatteryRequest> mapper) {
        super(repository, mapper);
    }
}
