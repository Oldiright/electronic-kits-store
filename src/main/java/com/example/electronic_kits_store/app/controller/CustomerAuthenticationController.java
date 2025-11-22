package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.auth.AuthenticationRequest;
import com.example.electronic_kits_store.app.dto.auth.AuthenticationResponse;
import com.example.electronic_kits_store.app.dto.customer.CreateCustomerRequest;
import com.example.electronic_kits_store.app.dto.customer.CustomerDTO;
import com.example.electronic_kits_store.app.service.CustomerAuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/customer")
@RequiredArgsConstructor
public class CustomerAuthenticationController {
    private final CustomerAuthenticationService customerAuthenticationService;
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.status(201).body(customerAuthenticationService.register(createCustomerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.status(201).body(customerAuthenticationService.authenticate(authenticationRequest));
    }
}
