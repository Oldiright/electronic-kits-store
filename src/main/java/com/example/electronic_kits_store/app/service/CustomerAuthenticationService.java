package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.auth.AuthenticationRequest;
import com.example.electronic_kits_store.app.dto.auth.AuthenticationResponse;
import com.example.electronic_kits_store.app.dto.customer.CreateCustomerRequest;
import com.example.electronic_kits_store.app.model.Customer;
import com.example.electronic_kits_store.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerAuthenticationService {
    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(CreateCustomerRequest request) {
        var customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password())) // Let's hash the password!
                .phoneNumber(request.phoneNumber())
                // .role(Role.CUSTOMER) - have already injected
                .build();

        repository.save(customer);

        var jwtToken = jwtService.generateToken(customer);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        var customer = repository.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found after successful authentication. Data inconsistency."));
        var jwtToken = jwtService.generateToken(customer);
        return new AuthenticationResponse(jwtToken);
    }
}
