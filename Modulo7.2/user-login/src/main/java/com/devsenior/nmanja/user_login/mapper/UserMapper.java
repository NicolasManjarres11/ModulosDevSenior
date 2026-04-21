package com.devsenior.nmanja.user_login.mapper;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.devsenior.nmanja.user_login.model.dto.RegisterRequest;
import com.devsenior.nmanja.user_login.model.dto.RegisterResponse;
import com.devsenior.nmanja.user_login.model.entity.User;

import lombok.RequiredArgsConstructor;


//@Component //Lo sube al contexto
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    
    public User toEntity(RegisterRequest register){

        

        return User.builder()
                .username(register.getUsername())
                .password(passwordEncoder.encode(register.getPassword()))
                .name(register.getName())
                .email(register.getEmail())
                .role(register.getRole())
                .isActive(true)
                .hireDate(LocalDate.now())
                .build();
    }

    public RegisterResponse toResponse(User user){
        return RegisterResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .hireDate(user.getHireDate())
                .isActive(user.isActive())
                .build();
    }
}
