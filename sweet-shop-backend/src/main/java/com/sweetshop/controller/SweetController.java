package com.sweetshop.controller;

import com.sweetshop.dto.PurchaseRequest;
import com.sweetshop.dto.SweetDTO;
import com.sweetshop.service.SweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SweetController {
    
    private final SweetService sweetService;
    
    @GetMapping
    public ResponseEntity<List<SweetDTO>> getAllSweets() {
        return ResponseEntity.ok(sweetService.getAllSweets());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<SweetDTO>> searchSweets(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return ResponseEntity.ok(sweetService.searchSweets(name, category, minPrice, maxPrice));
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SweetDTO> createSweet(@RequestBody SweetDTO sweetDTO) {
        return ResponseEntity.ok(sweetService.createSweet(sweetDTO));
    }
    
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SweetDTO> updateSweet(@PathVariable Long id, @RequestBody SweetDTO sweetDTO) {
        return ResponseEntity.ok(sweetService.updateSweet(id, sweetDTO));
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{id}/purchase")
    public ResponseEntity<SweetDTO> purchaseSweet(
            @PathVariable Long id,
            @RequestBody PurchaseRequest request) {
        return ResponseEntity.ok(sweetService.purchaseSweet(id, request));
    }
    
    @PostMapping("/{id}/restock")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SweetDTO> restockSweet(
            @PathVariable Long id,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok(sweetService.restockSweet(id, quantity));
    }
}
