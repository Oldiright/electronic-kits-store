package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.model.Miscellaneous;
import com.example.electronic_kits_store.app.model.PowerBlock;
import com.example.electronic_kits_store.app.repository.PowerBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PowerBlockService {
    private final PowerBlockRepository powerBlockRepository;

    public List<PowerBlock> findAll() {
        return powerBlockRepository.findAll();
    }
    public Optional<PowerBlock> findById(Long id) {
        return powerBlockRepository.findById(id);
    }

    public PowerBlock create(PowerBlock powerBlock) {
        return powerBlockRepository.save(powerBlock);
    }

    public void delete(Long id) { powerBlockRepository.deleteById(id); }

}
