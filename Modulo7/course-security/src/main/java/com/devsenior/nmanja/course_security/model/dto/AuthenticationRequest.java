package com.devsenior.nmanja.course_security.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    @NotBlank(message = "El 'username' es un campo obligatorio" )
    private String username;

    @NotBlank(message = "El 'password' es un campo obligatorio" )
    private String password;
    
}
