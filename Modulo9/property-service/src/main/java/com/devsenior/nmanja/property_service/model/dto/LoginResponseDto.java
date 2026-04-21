package com.devsenior.nmanja.property_service.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponseDto(
    @JsonProperty("access_token")
    String token,
    String username,

    @JsonProperty("name")
    String fullName,
    String email
) {}
