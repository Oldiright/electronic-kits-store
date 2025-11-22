package com.example.electronic_kits_store.app.service;

import com.example.electronic_kits_store.app.dto.auth.AuthenticationRequest;
import com.example.electronic_kits_store.app.dto.auth.AuthenticationResponse;
import com.example.electronic_kits_store.app.repository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserAuthenticationService {
    private final AdminUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        var adminUser = repository.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found after successful authentication. Data inconsistency."));
        var jwtToken = jwtService.generateToken(adminUser);
        return new AuthenticationResponse(jwtToken);
    }
}
