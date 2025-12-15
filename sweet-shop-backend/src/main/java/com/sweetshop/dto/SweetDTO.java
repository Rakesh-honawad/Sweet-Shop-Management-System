package com.sweetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SweetDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;
    private Integer quantity;  // CHANGED from stock to quantity
}