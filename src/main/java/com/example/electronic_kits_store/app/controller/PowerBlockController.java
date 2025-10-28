package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.powerblock.CreatePowerBlockRequest;
import com.example.electronic_kits_store.app.dto.powerblock.PowerBlockDTO;
import com.example.electronic_kits_store.app.service.PowerBlockService;
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
@RequestMapping("/api/powerBlock")
@RequiredArgsConstructor
public class PowerBlockController {
    private final PowerBlockService powerBlockService;
    @GetMapping("/{id}")
    public ResponseEntity<PowerBlockDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(powerBlockService.findById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<Page<PowerBlockDTO>>findAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(powerBlockService.findAll(pageable));
    }
    @PostMapping("/create")
    public ResponseEntity<PowerBlockDTO> create(@Valid @RequestBody CreatePowerBlockRequest createPowerBlockRequest) {
        return ResponseEntity.status(201).body(powerBlockService.create(createPowerBlockRequest));
    }
}
