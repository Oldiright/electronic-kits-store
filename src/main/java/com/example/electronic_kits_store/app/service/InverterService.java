package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.model.Bms;
import com.example.electronic_kits_store.app.model.Inverter;
import com.example.electronic_kits_store.app.repository.InverterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InverterService {
    private final InverterRepository inverterRepository;

    public List<Inverter> findAll() {
        return inverterRepository.findAll();
    }
}
