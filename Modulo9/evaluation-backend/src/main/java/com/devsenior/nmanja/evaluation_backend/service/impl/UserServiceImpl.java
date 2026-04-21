package com.devsenior.nmanja.evaluation_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.evaluation_backend.exception.UserException;
import com.devsenior.nmanja.evaluation_backend.mapper.UserMapper;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserRequestDto;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;
import com.devsenior.nmanja.evaluation_backend.model.entity.User;
import com.devsenior.nmanja.evaluation_backend.repository.UserRepository;
import com.devsenior.nmanja.evaluation_backend.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    


    

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        // Verificar si ya existe
        if (userRepository.existsByCode(userRequestDto.code())) {
            throw new UserException("Ya existe un usuario con ese código");
        }
        
        // Convertir y guardar
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        User savedUser = userRepository.save(user);
        
        return userMapper.userToUserResponseDto(savedUser);
    }

    @Override
    public void delete(Long code) {
        
        User user = userRepository.findByCode(code)
                .orElseThrow(() -> new UserException("Usuario no encontrado"));
        
        userRepository.delete(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToUserResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto getByCode(Long code) {

        
        User user = userRepository.findByCode(code)
                .orElseThrow(() -> new UserException("Usuario no encontrado"));
        
        return userMapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto update(Long code, UserRequestDto userRequestDto) {

        
        // Buscar usuario existente
        User existingUser = userRepository.findByCode(code)
                .orElseThrow(() -> new UserException("Usuario no encontrado"));
        
        // Verificar username duplicado
        if (!existingUser.getUsername().equals(userRequestDto.username()) && 
            userRepository.existsByUsername(userRequestDto.username())) {
            throw new UserException("Ya existe un usuario con ese username");
        }
        
        // Actualizar y guardar
        User updatedUser = userMapper.updateUserFromRequestDto(userRequestDto, existingUser);
        User savedUser = userRepository.save(updatedUser);
        
        return userMapper.userToUserResponseDto(savedUser);
    }
    
}
