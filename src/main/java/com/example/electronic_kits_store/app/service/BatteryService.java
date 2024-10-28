package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryService {
    private final BatteryRepository batteryRepository;

    public List<Battery> findAll() {
        return batteryRepository.findAll();
    }
}
