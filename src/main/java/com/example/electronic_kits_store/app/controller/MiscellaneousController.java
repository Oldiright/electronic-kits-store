package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.Miscellaneous.CreateMiscellaneousRequest;
import com.example.electronic_kits_store.app.dto.Miscellaneous.MiscellaneousDTO;
import com.example.electronic_kits_store.app.service.MiscellaneousService;
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
@RequestMapping("/api/miscellaneous")
@RequiredArgsConstructor
public class MiscellaneousController {
    private final MiscellaneousService miscellaneousService;
    @GetMapping("/{id}")
    public ResponseEntity<MiscellaneousDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(miscellaneousService.findById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<Page<MiscellaneousDTO>>findAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(miscellaneousService.findAll(pageable));
    }
    @PostMapping("/create")
    public ResponseEntity<MiscellaneousDTO> create(@RequestBody CreateMiscellaneousRequest createMiscellaneousRequest) {
        return ResponseEntity.status(201).body(miscellaneousService.create(createMiscellaneousRequest));
    }
}
