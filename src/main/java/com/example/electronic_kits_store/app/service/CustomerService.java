package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.customer.CreateCustomerRequest;
import com.example.electronic_kits_store.app.dto.customer.CustomerDTO;
import com.example.electronic_kits_store.app.mapper.customer.CustomerMapper;
import com.example.electronic_kits_store.app.repository.CustomerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDTO create(CreateCustomerRequest createCustomerRequest) {
        return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(createCustomerRequest)));
    }
}
