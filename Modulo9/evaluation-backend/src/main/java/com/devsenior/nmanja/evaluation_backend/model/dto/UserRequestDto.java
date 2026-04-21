package com.devsenior.nmanja.evaluation_backend.model.dto;

public record UserRequestDto(
    Long code,
    String name,
    String role,
    String username,
    String password
) {
    
}
