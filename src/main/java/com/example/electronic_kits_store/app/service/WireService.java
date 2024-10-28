package com.example.electronic_kits_store.app.service;
import com.example.electronic_kits_store.app.model.Wire;
import com.example.electronic_kits_store.app.repository.WireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WireService {
    private final WireRepository wireRepository;


    public List<Wire> findAll() {
        return wireRepository.findAll();
    }
}
