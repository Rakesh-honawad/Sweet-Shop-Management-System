package com.sweetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SweetDTO {
    private String id;  // Changed from Long
    private String name;
    private String description;
    private String category;
    private BigDecimal price;  // Changed from Double
    private String imageUrl;
    private Integer quantity;
}
