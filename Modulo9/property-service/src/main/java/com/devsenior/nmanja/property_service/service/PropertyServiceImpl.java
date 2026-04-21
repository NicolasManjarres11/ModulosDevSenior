package com.devsenior.nmanja.property_service.service;

import com.devsenior.nmanja.property_service.exception.PropertyNotFoundException;
import com.devsenior.nmanja.property_service.model.dto.PropertyRequestDto;
import com.devsenior.nmanja.property_service.model.dto.PropertyResponseDto;
import com.devsenior.nmanja.property_service.model.entity.Property;
import com.devsenior.nmanja.property_service.model.mapper.PropertyMapper;
import com.devsenior.nmanja.property_service.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    
    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;
    
    @Override
    public PropertyResponseDto save(PropertyRequestDto propertyRequestDto) {
        Property property = propertyMapper.toEntity(propertyRequestDto);
        Property savedProperty = propertyRepository.save(property);
        return propertyMapper.toResponseDto(savedProperty);
    }
    
    @Override
    public List<PropertyResponseDto> findAll() {
        List<Property> properties = propertyRepository.findAll();
        return propertyMapper.toResponseDtoList(properties);
    }
    
    @Override
    public PropertyResponseDto findById(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException(id));
        return propertyMapper.toResponseDto(property);
    }
    
    @Override
    public PropertyResponseDto update(Long id, PropertyRequestDto propertyRequestDto) {
        
        Property updatedProperty = propertyMapper.toEntity(propertyRequestDto);
        updatedProperty.setId(id);
        
        Property savedProperty = propertyRepository.save(updatedProperty);
        return propertyMapper.toResponseDto(savedProperty);
    }
    
    @Override
    public void deleteById(Long id) {
        if (!propertyRepository.existsById(id)) {
            throw new PropertyNotFoundException(id);
        }
        propertyRepository.deleteById(id);
    }
    
    @Override
    public List<PropertyResponseDto> findByCity(String city) {
        List<Property> properties = propertyRepository.findByCity(city);
        return propertyMapper.toResponseDtoList(properties);
    }
}
