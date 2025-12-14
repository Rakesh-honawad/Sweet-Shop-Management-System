package com.sweetshop.controller;

import com.sweetshop.dto.PurchaseRequest;
import com.sweetshop.dto.SweetDTO;
import com.sweetshop.service.SweetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sweets")
@RequiredArgsConstructor
public class SweetController {
    
    private final SweetService sweetService;
    
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(sweetService.getAllSweets());
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody SweetDTO dto) {
        return ResponseEntity.ok(sweetService.createSweet(dto));
    }
    
    @PostMapping("/{id}/purchase")
    public ResponseEntity<?> purchase(@PathVariable Long id, @Valid @RequestBody PurchaseRequest request) {
        return ResponseEntity.ok(sweetService.purchaseSweet(id, request));
    }
}