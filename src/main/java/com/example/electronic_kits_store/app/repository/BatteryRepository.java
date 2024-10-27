package com.example.electronic_kits_store.app.repository;

import com.example.electronic_kits_store.app.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery, Long> {
}
