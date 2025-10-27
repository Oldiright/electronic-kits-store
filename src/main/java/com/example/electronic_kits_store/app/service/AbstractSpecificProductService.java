package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class AbstractSpecificProductService<E, D, R> {
    private final JpaRepository<E, Long> repository;
    private final AbstractMapper<E, D, R> mapper;
    public D create(R createRequest) {
        return mapper.toDto(repository.save(mapper.toEntity(createRequest)));
    }

    public D findById(long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }
}
