package com.example.electronic_kits_store.app.dto.customer;

import com.example.electronic_kits_store.app.dto.order.OrderDTO;

import java.util.List;

public record CustomerDTO(

        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        List<OrderDTO> orders
) {
}
