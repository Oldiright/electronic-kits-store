package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.service.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/battery")
@RequiredArgsConstructor
public class BatteryController {

    private final BatteryService batteryService;
    @GetMapping("/{id}")
    public ResponseEntity<BatteryDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(batteryService.findById(id));

    }
    @GetMapping("/all")
    public ResponseEntity<List<BatteryDTO>>findAll() {
        return ResponseEntity.ok(batteryService.findAll());

    }
    @PostMapping("/create")
    public ResponseEntity<BatteryDTO> create(@RequestBody CreateBatteryRequest createBatteryRequest) {
        return ResponseEntity.status(201).body(batteryService.create(createBatteryRequest));
    }
}
