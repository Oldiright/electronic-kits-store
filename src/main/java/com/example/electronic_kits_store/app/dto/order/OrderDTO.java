package com.example.electronic_kits_store.app.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        Long id,
        LocalDateTime orderDateTime,
        BigDecimal totalPrice,
        String orderStatus,
        List<OrderItemDTO> orderItems
) {
}
