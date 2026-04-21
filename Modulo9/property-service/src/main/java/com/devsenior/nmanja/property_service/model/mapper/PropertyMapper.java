package com.devsenior.nmanja.property_service.model.mapper;

import com.devsenior.nmanja.property_service.model.dto.PropertyRequestDto;
import com.devsenior.nmanja.property_service.model.dto.PropertyResponseDto;
import com.devsenior.nmanja.property_service.model.entity.Property;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropertyMapper {
    
    // Convertir PropertyRequestDto a Property (entidad)
    Property toEntity(PropertyRequestDto dto);
    
    // Convertir Property (entidad) a PropertyResponseDto
    PropertyResponseDto toResponseDto(Property property);
    
    // Convertir lista de Property a lista de PropertyResponseDto
    List<PropertyResponseDto> toResponseDtoList(List<Property> properties);
}
