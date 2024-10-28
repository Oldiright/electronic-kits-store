package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.model.Bms;
import com.example.electronic_kits_store.app.repository.BmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BmsService {
    private final BmsRepository bmsRepository;


    public List<Bms> findAll() {
        return bmsRepository.findAll();
    }
    public Optional<Bms> findById(Long id) {
        return bmsRepository.findById(id);
    }

    public Bms create(Bms bms) {
        return bmsRepository.save(bms);
    }

    public void delete(Long id) { bmsRepository.deleteById(id); }

}
