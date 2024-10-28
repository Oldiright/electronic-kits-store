package com.example.electronic_kits_store.app.service;
import com.example.electronic_kits_store.app.model.Wire;
import com.example.electronic_kits_store.app.repository.WireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WireService {
    private final WireRepository wireRepository;


    public List<Wire> findAll() {
        return wireRepository.findAll();
    }

    public Optional<Wire> findById(Long id) {
        return wireRepository.findById(id);
    }

    public Wire create(Wire wire) {
        return wireRepository.save(wire);
    }

    public void delete(Long id) { wireRepository.deleteById(id); }
}

