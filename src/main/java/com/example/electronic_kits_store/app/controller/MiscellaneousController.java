package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.Miscellaneous.CreateMiscellaneousRequest;
import com.example.electronic_kits_store.app.dto.Miscellaneous.MiscellaneousDTO;
import com.example.electronic_kits_store.app.service.MiscellaneousService;
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
@RequestMapping("/api/miscellaneous")
@RequiredArgsConstructor
public class MiscellaneousController {
    private final MiscellaneousService miscellaneousService;
    @GetMapping("/{id}")
    public ResponseEntity<MiscellaneousDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(miscellaneousService.findById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<MiscellaneousDTO>>findAll() {
        return ResponseEntity.ok(miscellaneousService.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<MiscellaneousDTO> create(@RequestBody CreateMiscellaneousRequest createMiscellaneousRequest) {
        return ResponseEntity.status(201).body(miscellaneousService.create(createMiscellaneousRequest));
    }
}
