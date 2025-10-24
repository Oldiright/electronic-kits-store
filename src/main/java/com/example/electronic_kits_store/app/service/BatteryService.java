package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.BatteryDTO;
import com.example.electronic_kits_store.app.dto.CreateBatteryRequest;
import com.example.electronic_kits_store.app.mapper.BatteryMapper;
import com.example.electronic_kits_store.app.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryService {
    private final BatteryRepository batteryRepository;
    private  final BatteryMapper batteryMapper;


    public BatteryDTO create(CreateBatteryRequest createBatteryRequest) {
        return batteryMapper.toDto(batteryRepository.save(batteryMapper.toEntity(createBatteryRequest)));
    }

    public BatteryDTO findById(long id) {
        return batteryMapper.toDto(batteryRepository.findById(id).orElseThrow());
    }
    public List<BatteryDTO> findAll() {
        return batteryRepository.findAll().stream().map(batteryMapper::toDto).toList();
    }
}
