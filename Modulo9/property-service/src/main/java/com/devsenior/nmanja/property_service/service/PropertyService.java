package com.devsenior.nmanja.property_service.service;

import com.devsenior.nmanja.property_service.model.dto.PropertyRequestDto;
import com.devsenior.nmanja.property_service.model.dto.PropertyResponseDto;

import java.util.List;

public interface PropertyService {
    
    // Operaciones CRUD básicas
    PropertyResponseDto save(PropertyRequestDto propertyRequestDto);
    
    List<PropertyResponseDto> findAll();
    
    PropertyResponseDto findById(Long id);
    
    PropertyResponseDto update(Long id, PropertyRequestDto propertyRequestDto);
    
    void deleteById(Long id);
    
    // Método para listar propiedades por ciudad
    List<PropertyResponseDto> findByCity(String city);
}
