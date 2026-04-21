package com.devsenior.nmanja.property_service.model.dto;

public record RegisterResponseDto(
    Long id,
    String username,
    String email,
    String fullName,
    String message
) {}
