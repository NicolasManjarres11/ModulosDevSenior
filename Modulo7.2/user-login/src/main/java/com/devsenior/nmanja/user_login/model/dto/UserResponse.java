package com.devsenior.nmanja.user_login.model.dto;

import java.time.LocalDate;

import com.devsenior.nmanja.user_login.model.shared.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    
    private String username;

    private String name;

    private String email;

    private LocalDate hireDate;

    private boolean isActive;

    private Role role;



}
