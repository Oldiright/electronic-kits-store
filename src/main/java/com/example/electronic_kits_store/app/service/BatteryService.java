package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatteryService {
    private final BatteryRepository batteryRepository;

    public List<Battery> findAll() {
        return batteryRepository.findAll();
    }
    public Optional<Battery> findById(Long id) {
        return batteryRepository.findById(id);
    }

    public Battery create(Battery battery) {return batteryRepository.save(battery);
    }

    public void delete(long id) {
        batteryRepository.deleteById(id);
    }
}
