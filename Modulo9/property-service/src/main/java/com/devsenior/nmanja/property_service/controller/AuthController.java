package com.devsenior.nmanja.property_service.controller;

import com.devsenior.nmanja.property_service.model.dto.LoginRequestDto;
import com.devsenior.nmanja.property_service.model.dto.LoginResponseDto;
import com.devsenior.nmanja.property_service.model.dto.RegisterRequestDto;
import com.devsenior.nmanja.property_service.model.dto.RegisterResponseDto;
import com.devsenior.nmanja.property_service.model.dto.TokenValidationResponseDto;
import com.devsenior.nmanja.property_service.service.AuthService;
import com.devsenior.nmanja.property_service.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    
    private final AuthService authService;
    private final JwtService jwtService;
    
    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }
    
    @PostMapping("/register")
    public RegisterResponseDto register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        return authService.register(registerRequestDto);
    }
    
    @PostMapping("/validate")
    public TokenValidationResponseDto validateToken(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                
                if (jwtService.isTokenValid(token)) {
                    String username = jwtService.extractUsername(token);
                    Long userId = jwtService.extractUserId(token);
                    
                    return new TokenValidationResponseDto(true, username, userId, "Token válido");
                } else {
                    return new TokenValidationResponseDto(false, null, null, "Token expirado o inválido");
                }
            } else {
                return new TokenValidationResponseDto(false, null, null, "Formato de autorización inválido");
            }
        } catch (Exception e) {
            return new TokenValidationResponseDto(false, null, null, "Error validando token: " + e.getMessage());
        }
    }
}
