package com.devsenior.nmanja.property_service.model.dto;

import lombok.Data;

@Data
public class PropertyResponseDto {
    
    private Long id;
    private String address;
    private String city;
    private Double price;
    private Integer bedrooms;
    private Integer bathrooms;
    private String imageUrl;
    private String description;
}
