package com.example.electronic_kits_store.app.controller;
import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.service.BmsService;
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
@RequestMapping("/api/bms")
@RequiredArgsConstructor
public class BmsController {
    private final BmsService bmsService;
    @GetMapping("/{id}")
    public ResponseEntity<BmsDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(bmsService.findById(id));

    }
    @GetMapping("/all")
    public ResponseEntity<List<BmsDTO>>findAll() {
        return ResponseEntity.ok(bmsService.findAll());

    }
    @PostMapping("/create")
    public ResponseEntity<BmsDTO> create(@RequestBody CreateBmsRequest createBmsRequest) {
        return ResponseEntity.status(201).body(bmsService.create(createBmsRequest));
    }
}
