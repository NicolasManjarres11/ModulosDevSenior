package com.devsenior.nmanja.evaluation_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.devsenior.nmanja.evaluation_backend.model.dto.UserRequestDto;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;
import com.devsenior.nmanja.evaluation_backend.model.entity.Role;
import com.devsenior.nmanja.evaluation_backend.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    /**
     * Convierte UserRequestDto a User (para crear usuarios)
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", source = "role", qualifiedByName = "stringToRole")
    User userRequestDtoToUser(UserRequestDto userRequestDto);
    
    /**
     * Convierte User a UserResponseDto (para respuestas)
     */
    @Mapping(target = "role", source = "role", qualifiedByName = "roleToString")
    UserResponseDto userToUserResponseDto(User user);
    
    /**
     * Convierte UserRequestDto a User (para actualizaciones)
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", source = "role", qualifiedByName = "stringToRole")
    User updateUserFromRequestDto(UserRequestDto userRequestDto, @MappingTarget User user);
    
    /**
     * Convierte String a Role enum
     */
    @Named("stringToRole")
    default Role stringToRole(String role) {
        if (role == null) {
            return null;
        }
        try {
            return Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    
    /**
     * Convierte Role enum a String
     */
    @Named("roleToString")
    default String roleToString(Role role) {
        if (role == null) {
            return null;
        }
        return role.name();
    }
}
