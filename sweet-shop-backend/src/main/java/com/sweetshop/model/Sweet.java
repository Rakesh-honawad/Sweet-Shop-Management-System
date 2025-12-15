package com.sweetshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "sweets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sweet {
    @Id
    private String id;
    
    private String name;
    private String description;
    private String category;
    private BigDecimal price;  // ✅ Make sure this is BigDecimal, NOT Double
    private String imageUrl;
    private Integer stock;
}
