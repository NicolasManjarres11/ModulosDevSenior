package com.devsenior.nmanja.property_service.controller;

import com.devsenior.nmanja.property_service.model.dto.PropertyRequestDto;
import com.devsenior.nmanja.property_service.model.dto.PropertyResponseDto;
import com.devsenior.nmanja.property_service.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PropertyController {
    
    private final PropertyService propertyService;
    
    // POST - Crear una nueva propiedad
    @PostMapping
    public PropertyResponseDto createProperty(@Valid @RequestBody PropertyRequestDto propertyRequestDto) {
        return propertyService.save(propertyRequestDto);
    }
    
    // GET - Obtener todas las propiedades
    @GetMapping
    public List<PropertyResponseDto> getAllProperties() {
        return propertyService.findAll();
    }
    
    // GET - Obtener una propiedad por ID
    @GetMapping("/{id}")
    public PropertyResponseDto getPropertyById(@PathVariable Long id) {
        return propertyService.findById(id);
    }
    
    // PUT - Actualizar una propiedad existente
    @PutMapping("/{id}")
    public PropertyResponseDto updateProperty(
            @PathVariable Long id, 
            @Valid @RequestBody PropertyRequestDto propertyRequestDto) {
        return propertyService.update(id, propertyRequestDto);
    }
    
    // DELETE - Eliminar una propiedad
    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteById(id);
    }
    
    // GET - Buscar propiedades por ciudad
    @GetMapping("/city/{city}")
    public List<PropertyResponseDto> getPropertiesByCity(@PathVariable String city) {
        return propertyService.findByCity(city);
    }
    
    // GET - Buscar propiedades por ciudad con parámetro de consulta
    @GetMapping("/search")
    public List<PropertyResponseDto> searchPropertiesByCity(@RequestParam String city) {
        return propertyService.findByCity(city);
    }
}
