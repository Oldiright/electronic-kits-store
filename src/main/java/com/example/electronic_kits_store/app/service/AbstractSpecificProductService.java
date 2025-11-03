package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.exception.DuplicateProductNameException;
import com.example.electronic_kits_store.app.exception.ResourceNotFoundException;
import com.example.electronic_kits_store.app.mapper.AbstractMapper;
import com.example.electronic_kits_store.app.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


@RequiredArgsConstructor
public class AbstractSpecificProductService<E extends Product, D, R> {
    private final JpaRepository<E, Long> repository;
    private final AbstractMapper<E, D, R> mapper;
    public D create(R createRequest) {
        try {
            return mapper.toDto(repository.save(mapper.toEntity(createRequest)));
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("uq_product_name")) {
                throw new DuplicateProductNameException("Продукт з такою назвою вже існує");
            }
            throw e;
        }
    }
    public D findById(long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id = %s not found.", id))));
    }
    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }
}
