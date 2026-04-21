package com.devsenior.nmanja.property_service.service;

import com.devsenior.nmanja.property_service.model.dto.LoginRequestDto;
import com.devsenior.nmanja.property_service.model.dto.LoginResponseDto;
import com.devsenior.nmanja.property_service.model.dto.RegisterRequestDto;
import com.devsenior.nmanja.property_service.model.dto.RegisterResponseDto;

public interface AuthService {
    
    LoginResponseDto login(LoginRequestDto loginRequestDto);
    
    RegisterResponseDto register(RegisterRequestDto registerRequestDto);
}
