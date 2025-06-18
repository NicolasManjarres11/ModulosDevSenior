package com.devsenior.nmanja.user_register_demo.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterRequest {

    @NotBlank(message = "El username es un campo requerido")
    private String userName;

    @NotBlank(message = "El password es un campo requerido")
    private String password;

    @JsonProperty(value = "first_name")
    @NotBlank(message = "El nombre es un campo requerido")
    private String firstName;

    @JsonProperty(value = "last_name")
    @NotBlank(message = "El apellido es un campo requerido")
    private String lastName;

    @NotBlank(message = "El correo electrónico es un campo requerido")
    @Email(message = "El correo electrónico no es válido")
    private String email;

    @JsonProperty(value = "phone_number")
    private String phoneNumber;


    private String city;
    
}
