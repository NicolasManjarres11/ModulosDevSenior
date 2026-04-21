package com.devsenior.nmanja.property_service.model.mapper;

import com.devsenior.nmanja.property_service.model.dto.LoginResponseDto;
import com.devsenior.nmanja.property_service.model.dto.RegisterRequestDto;
import com.devsenior.nmanja.property_service.model.dto.RegisterResponseDto;
import com.devsenior.nmanja.property_service.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(target = "token", ignore = true)
    LoginResponseDto toLoginResponseDto(User user);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", constant = "true")
    User toEntity(RegisterRequestDto dto);
    
    @Mapping(target = "message", constant = "Usuario registrado exitosamente")
    RegisterResponseDto toRegisterResponseDto(User user);
}
