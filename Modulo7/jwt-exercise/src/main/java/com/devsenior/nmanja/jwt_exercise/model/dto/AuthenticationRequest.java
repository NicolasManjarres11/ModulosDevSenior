package com.devsenior.nmanja.jwt_exercise.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class AuthenticationRequest {
    
    private String username;
    private String password;

}
