package com.example.electronic_kits_store.app.dto.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest (
        @NotBlank(message = "Вкажіть e-mail")
        @Email(message = "Невірний формат електронної адреси.")
        String email,
        @NotBlank(message = "Вкажіть пароль")
        String password
){}
