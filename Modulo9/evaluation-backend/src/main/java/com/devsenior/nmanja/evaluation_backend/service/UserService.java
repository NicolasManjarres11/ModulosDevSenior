package com.devsenior.nmanja.evaluation_backend.service;

import java.util.List;

import com.devsenior.nmanja.evaluation_backend.model.dto.UserRequestDto;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;

public interface UserService{

    List<UserResponseDto> getAll();
    UserResponseDto getByCode(Long code);
    UserResponseDto create(UserRequestDto user);
    UserResponseDto update(Long code, UserRequestDto user);
    void delete (Long code);
    
}
