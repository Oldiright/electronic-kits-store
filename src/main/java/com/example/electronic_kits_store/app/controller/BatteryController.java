package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.service.BatteryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Page<BatteryDTO>>findAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(batteryService.findAll(pageable));

    }
    @PostMapping("/create")
    public ResponseEntity<BatteryDTO> create(@Valid @RequestBody CreateBatteryRequest createBatteryRequest) {
        return ResponseEntity.status(201).body(batteryService.create(createBatteryRequest));
    }
}
