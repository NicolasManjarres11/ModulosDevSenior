package com.devsenior.nmanja.evaluation_backend.model.dto;

public record UserResponseDto(
    Long code,
    String name,
    String role,
    String username
) {
    
}
