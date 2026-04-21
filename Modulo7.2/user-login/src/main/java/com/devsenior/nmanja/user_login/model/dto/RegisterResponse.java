package com.devsenior.nmanja.user_login.model.dto;

import java.time.LocalDate;

import com.devsenior.nmanja.user_login.model.shared.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class RegisterResponse {
    
    private String username;

    private String name;

    private String email;

    private LocalDate hireDate;

    private boolean isActive;

    private Role role;
}
