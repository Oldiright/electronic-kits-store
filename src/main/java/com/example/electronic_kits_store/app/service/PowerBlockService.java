package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.model.PowerBlock;
import com.example.electronic_kits_store.app.repository.PowerBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PowerBlockService {
    private final PowerBlockRepository powerBlockRepository;

    public List<PowerBlock> findAll() {
        return powerBlockRepository.findAll();
    }
}
