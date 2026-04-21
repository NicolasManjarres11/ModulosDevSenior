package com.devsenior.nmanja.property_service.model.dto;

import lombok.Data;

@Data
public class PropertySearchDto {
    
    private String city;
    private Double minPrice;
    private Double maxPrice;
    private Integer minBedrooms;
    private Integer minBathrooms;
}
