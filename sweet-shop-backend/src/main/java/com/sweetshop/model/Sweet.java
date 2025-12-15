package com.sweetshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sweets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String category;
    private Double price;
    private String imageUrl;
    private Integer stock;
}
