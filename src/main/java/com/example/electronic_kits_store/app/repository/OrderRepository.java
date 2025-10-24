package com.example.electronic_kits_store.app.repository;

import com.example.electronic_kits_store.app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
