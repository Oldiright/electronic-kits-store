package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.model.Wire;
import com.example.electronic_kits_store.app.model.WireLug;
import com.example.electronic_kits_store.app.repository.WireLugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WireLugService {
    private final WireLugRepository wireLugRepository;

    public List<WireLug> findAll() {
        return wireLugRepository.findAll();
    }
}
