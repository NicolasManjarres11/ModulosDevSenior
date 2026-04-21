package com.devsenior.nmanja.property_service.model.dto;

public record TokenValidationResponseDto(
    boolean valid,
    String username,
    Long userId,
    String message
) {}
