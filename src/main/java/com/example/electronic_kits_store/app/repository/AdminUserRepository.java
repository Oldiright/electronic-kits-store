package com.example.electronic_kits_store.app.repository;

import com.example.electronic_kits_store.app.model.Customer;
import com.example.electronic_kits_store.app.model.admin.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    Optional<Customer> findByEmail(String email);
}
