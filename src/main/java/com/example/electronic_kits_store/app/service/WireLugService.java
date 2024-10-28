package com.example.electronic_kits_store.app.service;
import com.example.electronic_kits_store.app.model.PowerBlock;
import com.example.electronic_kits_store.app.model.WireLug;
import com.example.electronic_kits_store.app.repository.WireLugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WireLugService {
    private final WireLugRepository wireLugRepository;

    public List<WireLug> findAll() {
        return wireLugRepository.findAll();
    }

    public Optional<WireLug> findById(Long id) {
        return wireLugRepository.findById(id);
    }

    public WireLug create(WireLug wireLug) {
        return wireLugRepository.save(wireLug);
    }

    public void delete(Long id) { wireLugRepository.deleteById(id); }
}
