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
                .category(dto.getCategory())
                .price(BigDecimal.valueOf(dto.getPrice()))
                .quantity(dto.getQuantity())
                .build();
        return convertToDTO(sweetRepository.save(sweet));
    }
    
    @Transactional
    public SweetDTO purchaseSweet(Long id, PurchaseRequest request) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));
        
        if (sweet.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient quantity");
        }
        
        sweet.setQuantity(sweet.getQuantity() - request.getQuantity());
        return convertToDTO(sweetRepository.save(sweet));
    }
    
    @Transactional
    public SweetDTO restockSweet(Long id, Integer quantity) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));
        sweet.setQuantity(sweet.getQuantity() + quantity);
        return convertToDTO(sweetRepository.save(sweet));
    }
    
    @Transactional
    public SweetDTO updateSweet(Long id, SweetDTO dto) {
        Sweet sweet = sweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sweet not found"));
        sweet.setName(dto.getName());
        sweet.setCategory(dto.getCategory());
        sweet.setPrice(BigDecimal.valueOf(dto.getPrice()));
        sweet.setQuantity(dto.getQuantity());
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
                .category(sweet.getCategory())
                .price(sweet.getPrice().doubleValue())
                .quantity(sweet.getQuantity())
                .build();
    }
}
