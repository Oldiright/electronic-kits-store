package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.service.InverterService;
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

import java.util.List;

@RestController
@RequestMapping("/api/inverter")
@RequiredArgsConstructor
public class InverterController {
    private final InverterService inverterService;
    @GetMapping("/{id}")
    public ResponseEntity<InverterDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(inverterService.findById(id));

    }
    @GetMapping("/all")
    public ResponseEntity<Page<InverterDTO>>findAll(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(inverterService.findAll(pageable));

    }
    @PostMapping("/create")
    public ResponseEntity<InverterDTO> create(@RequestBody CreateInverterRequest createInverterRequest) {
        return ResponseEntity.status(201).body(inverterService.create(createInverterRequest));
    }
}
