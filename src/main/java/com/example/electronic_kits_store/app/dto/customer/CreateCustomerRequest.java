package com.example.electronic_kits_store.app.dto.customer;

import com.example.electronic_kits_store.app.validation.ValidPhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateCustomerRequest(
        @NotBlank(message = "Вкажіть ім'я")
        String firstName,
        @NotBlank(message = "Вкажіть прізвище")
        String lastName,
        @NotBlank(message = "Вкажіть e-mail")
        @Email(message = "Невірний формат електронної адреси.")
        String email,
        @NotBlank(message = "Вкажіть номер")
        @ValidPhoneNumber(region = "UA")
        String phoneNumber,
        @NotBlank(message = "Вкажіть пароль")
        String password
) {
}
