package com.example.electronic_kits_store.app.repository;

import com.example.electronic_kits_store.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
