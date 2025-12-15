package com.sweetshop.service;

import com.sweetshop.dto.PurchaseRequest;
import com.sweetshop.dto.SweetDTO;
import com.sweetshop.model.Sweet;
import com.sweetshop.repository.SweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SweetService {

    @Autowired
    private SweetRepository sweetRepository;

    public Sweet createSweet(SweetDTO dto) {
        Sweet sweet = Sweet.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .stock(dto.getQuantity())
                .build();
        return sweetRepository.save(sweet);
    }

    public Sweet purchaseSweet(String id, PurchaseRequest request) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        if (sweet.getStock() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        sweet.setStock(sweet.getStock() - request.getQuantity());
        return sweetRepository.save(sweet);
    }

    public Sweet restockSweet(String id, Integer quantity) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        sweet.setStock(sweet.getStock() + quantity);
        return sweetRepository.save(sweet);
    }

    public Sweet updateSweet(String id, SweetDTO dto) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));

        sweet.setName(dto.getName());
        sweet.setDescription(dto.getDescription());
        sweet.setCategory(dto.getCategory());
        sweet.setPrice(dto.getPrice());
        sweet.setImageUrl(dto.getImageUrl());
        sweet.setStock(dto.getQuantity());

        return sweetRepository.save(sweet);
    }

    public void deleteSweet(String id) {
        sweetRepository.deleteById(id);
    }

    public List<Sweet> searchSweets(String name, String category, BigDecimal minPrice, BigDecimal maxPrice) {
        return sweetRepository.findAll().stream()
                .filter(s -> name == null || s.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(s -> category == null || s.getCategory().equalsIgnoreCase(category))
                .filter(s -> minPrice == null || s.getPrice().compareTo(minPrice) >= 0)
                .filter(s -> maxPrice == null || s.getPrice().compareTo(maxPrice) <= 0)
                .collect(Collectors.toList());
    }

    private SweetDTO convertToDTO(Sweet sweet) {
        return SweetDTO.builder()
                .id(sweet.getId())
                .name(sweet.getName())
                .description(sweet.getDescription())
                .price(sweet.getPrice())
                .imageUrl(sweet.getImageUrl())
                .category(sweet.getCategory())
                .quantity(sweet.getStock())
                .build();
    }
}
