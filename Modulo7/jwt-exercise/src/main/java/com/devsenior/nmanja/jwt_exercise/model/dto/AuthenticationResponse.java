package com.devsenior.nmanja.jwt_exercise.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    
    private String jwt;

}
