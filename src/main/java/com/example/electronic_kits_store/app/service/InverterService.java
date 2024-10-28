package com.example.electronic_kits_store.app.service;
import com.example.electronic_kits_store.app.model.Inverter;
import com.example.electronic_kits_store.app.repository.InverterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InverterService {
    private final InverterRepository inverterRepository;

    public List<Inverter> findAll() {
        return inverterRepository.findAll();
    }

    public Optional<Inverter> findById(Long id) {
        return inverterRepository.findById(id);
    }

    public Inverter create(Inverter inverter) {
        return inverterRepository.save(inverter);
    }

    public void delete(Long id) { inverterRepository.deleteById(id); }
}
