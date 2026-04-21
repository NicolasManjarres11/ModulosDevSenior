package com.devsenior.nmanja.property_service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class PropertyRequestDto {
    
    @NotBlank(message = "La dirección es obligatoria")
    private String address;
    
    @NotBlank(message = "La ciudad es obligatoria")
    private String city;
    
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double price;
    
    @NotNull(message = "El número de habitaciones es obligatorio")
    @PositiveOrZero(message = "El número de habitaciones debe ser mayor o igual a 0")
    private Integer bedrooms;
    
    @NotNull(message = "El número de baños es obligatorio")
    @PositiveOrZero(message = "El número de baños debe ser mayor o igual a 0")
    private Integer bathrooms;
    
    private String imageUrl;
    
    private String description;
}
