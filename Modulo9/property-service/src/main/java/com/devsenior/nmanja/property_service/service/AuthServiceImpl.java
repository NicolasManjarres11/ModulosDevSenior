package com.devsenior.nmanja.property_service.service;

import com.devsenior.nmanja.property_service.exception.AuthenticationException;
import com.devsenior.nmanja.property_service.exception.UserAlreadyExistsException;
import com.devsenior.nmanja.property_service.model.dto.LoginRequestDto;
import com.devsenior.nmanja.property_service.model.dto.LoginResponseDto;
import com.devsenior.nmanja.property_service.model.dto.RegisterRequestDto;
import com.devsenior.nmanja.property_service.model.dto.RegisterResponseDto;
import com.devsenior.nmanja.property_service.model.entity.User;
import com.devsenior.nmanja.property_service.model.mapper.UserMapper;
import com.devsenior.nmanja.property_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByUsername(loginRequestDto.username())
                .orElseThrow(() -> new AuthenticationException("Credenciales inválidas"));
        
        // Validar contraseña usando PasswordEncoder
        if (!passwordEncoder.matches(loginRequestDto.password(), user.getPassword())) {
            throw new AuthenticationException("Credenciales inválidas");
        }
        
        if (!user.getIsActive()) {
            throw new AuthenticationException("Usuario inactivo");
        }
        
        // Generar token JWT
        String token = jwtService.generateToken(user);
        
        // Crear respuesta con token JWT
        LoginResponseDto response = userMapper.toLoginResponseDto(user);
        return new LoginResponseDto(token, response.username(), response.fullName(), response.email());
    }
    
    @Override
    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        // Verificar si el username ya existe
        if (userRepository.existsByUsername(registerRequestDto.username())) {
            throw new UserAlreadyExistsException("El nombre de usuario ya está en uso");
        }
        
        // Verificar si el email ya existe
        if (userRepository.existsByEmail(registerRequestDto.email())) {
            throw new UserAlreadyExistsException("El email ya está registrado");
        }
        
        // Crear nuevo usuario con contraseña encriptada
        User newUser = userMapper.toEntity(registerRequestDto);
        newUser.setPassword(passwordEncoder.encode(registerRequestDto.password()));
        User savedUser = userRepository.save(newUser);
        
        return userMapper.toRegisterResponseDto(savedUser);
    }
}
