package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import com.example.electronic_kits_store.app.mapper.BmsMapper;
import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Bms;
import com.example.electronic_kits_store.app.repository.BmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BmsService extends AbstractSpecificProductService<Bms, BmsDTO, CreateBmsRequest> {
    public BmsService(JpaRepository<Bms, Long> repository, AbstractMapper<Bms, BmsDTO, CreateBmsRequest> mapper) {
        super(repository, mapper);
    }
}
