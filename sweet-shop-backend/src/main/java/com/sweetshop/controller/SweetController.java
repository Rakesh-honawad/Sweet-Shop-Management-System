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
    
    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return ResponseEntity.ok(sweetService.searchSweets(name, category, minPrice, maxPrice));
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody SweetDTO dto) {
        return ResponseEntity.ok(sweetService.createSweet(dto));
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody SweetDTO dto) {
        return ResponseEntity.ok(sweetService.updateSweet(id, dto));
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        sweetService.deleteSweet(id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/{id}/purchase")
    public ResponseEntity<?> purchase(@PathVariable Long id, @Valid @RequestBody PurchaseRequest request) {
        return ResponseEntity.ok(sweetService.purchaseSweet(id, request));
    }
    
    @PostMapping("/{id}/restock")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> restock(@PathVariable Long id, @RequestBody PurchaseRequest request) {
        return ResponseEntity.ok(sweetService.restockSweet(id, request.getQuantity()));
    }
}
