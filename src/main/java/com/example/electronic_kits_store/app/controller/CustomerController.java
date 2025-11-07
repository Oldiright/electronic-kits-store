package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.customer.CreateCustomerRequest;
import com.example.electronic_kits_store.app.dto.customer.CustomerDTO;
import com.example.electronic_kits_store.app.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.status(201).body(customerService.create(createCustomerRequest));
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.status(201).body(customerService.create(createCustomerRequest));
    }

}
