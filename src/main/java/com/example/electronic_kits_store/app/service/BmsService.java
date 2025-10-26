package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.mapper.BmsMapper;
import com.example.electronic_kits_store.app.repository.BmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BmsService {
    private final BmsRepository bmsRepository;
    private final BmsMapper bmsMapper;


    public BmsDTO create(CreateBmsRequest createBmsRequest) {
        return bmsMapper.toDto(bmsRepository.save(bmsMapper.toEntity(createBmsRequest)));
    }

    public BmsDTO findById(long id) {
        return bmsMapper.toDto(bmsRepository.findById(id).orElseThrow());
    }
    public List<BmsDTO> findAll() {
        return bmsRepository.findAll().stream().map(bmsMapper::toDto).toList();
    }
}
