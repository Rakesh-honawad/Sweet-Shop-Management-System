package com.sweetshop.service;

import com.sweetshop.dto.PurchaseRequest;
import com.sweetshop.dto.SweetDTO;
import com.sweetshop.model.Sweet;
import com.sweetshop.repository.SweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SweetService {
    
    private final SweetRepository sweetRepository;
    
    public List<SweetDTO> getAllSweets() {
        return sweetRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
public SweetDTO createSweet(SweetDTO dto) {
    Sweet sweet = Sweet.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .category(dto.getCategory())
            .price(dto.getPrice().doubleValue())
            .imageUrl(dto.getImageUrl())
            .stock(dto.getQuantity())  // Map quantity to stock
            .build();
    return convertToDTO(sweetRepository.save(sweet));
}
    
    @Transactional
    public SweetDTO purchaseSweet(Long id, PurchaseRequest request) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));
        
        if (sweet.getStock() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }
        
        sweet.setStock(sweet.getStock() - request.getQuantity());
        return convertToDTO(sweetRepository.save(sweet));
    }
    
    @Transactional
    public SweetDTO restockSweet(Long id, Integer quantity) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));
        sweet.setStock(sweet.getStock() + quantity);
        return convertToDTO(sweetRepository.save(sweet));
    }
    
@Transactional
public SweetDTO updateSweet(Long id, SweetDTO dto) {
    Sweet sweet = sweetRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Sweet not found"));
    sweet.setName(dto.getName());
    sweet.setDescription(dto.getDescription());
    sweet.setCategory(dto.getCategory());
    sweet.setPrice(dto.getPrice().doubleValue());
    sweet.setImageUrl(dto.getImageUrl());
    sweet.setStock(dto.getQuantity());  // Map quantity to stock
    return convertToDTO(sweetRepository.save(sweet));
}
    
    public void deleteSweet(Long id) {
        sweetRepository.deleteById(id);
    }
    
    public List<SweetDTO> searchSweets(String name, String category, Double minPrice, Double maxPrice) {
        return sweetRepository.findAll().stream()
                .filter(s -> name == null || s.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(s -> category == null || s.getCategory().equalsIgnoreCase(category))
                .filter(s -> minPrice == null || s.getPrice().doubleValue() >= minPrice)
                .filter(s -> maxPrice == null || s.getPrice().doubleValue() <= maxPrice)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
private SweetDTO convertToDTO(Sweet sweet) {
    return SweetDTO.builder()
            .id(sweet.getId())
            .name(sweet.getName())
            .description(sweet.getDescription())
            .price(sweet.getPrice().doubleValue())
            .imageUrl(sweet.getImageUrl())
            .category(sweet.getCategory())
            .quantity(sweet.getStock())  // Map stock to quantity
            .build();
}
}
