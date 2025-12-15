package com.sweetshop.controller;

import com.sweetshop.dto.PurchaseRequest;
import com.sweetshop.dto.SweetDTO;
import com.sweetshop.model.Sweet;
import com.sweetshop.service.SweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    @Autowired
    private SweetService sweetService;

    @PostMapping
    public ResponseEntity<Sweet> createSweet(@RequestBody SweetDTO sweetDTO) {
        return ResponseEntity.ok(sweetService.createSweet(sweetDTO));
    }

    @GetMapping
    public ResponseEntity<List<Sweet>> getAllSweets() {
        return ResponseEntity.ok(sweetService.searchSweets(null, null, null, null));
    }

    @PostMapping("/{id}/purchase")
    public ResponseEntity<Sweet> purchaseSweet(@PathVariable String id, @RequestBody PurchaseRequest request) {
        return ResponseEntity.ok(sweetService.purchaseSweet(id, request));
    }

    @PutMapping("/{id}/restock")
    public ResponseEntity<Sweet> restockSweet(@PathVariable String id, @RequestParam Integer quantity) {
        return ResponseEntity.ok(sweetService.restockSweet(id, quantity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sweet> updateSweet(@PathVariable String id, @RequestBody SweetDTO sweetDTO) {
        return ResponseEntity.ok(sweetService.updateSweet(id, sweetDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSweet(@PathVariable String id) {
        sweetService.deleteSweet(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Sweet>> searchSweets(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {
        return ResponseEntity.ok(sweetService.searchSweets(name, category, minPrice, maxPrice));
    }
}
