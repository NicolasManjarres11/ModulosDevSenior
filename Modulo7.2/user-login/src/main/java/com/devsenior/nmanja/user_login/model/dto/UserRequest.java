package com.devsenior.nmanja.user_login.model.dto;

import org.hibernate.validator.constraints.Length;

import com.devsenior.nmanja.user_login.model.shared.Role;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @Length(min = 5, message = "El nombre de usuario debe tener mínimo 5 caracteres.")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Length(min = 5, message = "La contraseña debe contener mínimo 5 caracteres.")
    private String password;

    @NotBlank(message = "El nombre es obligatorio.")
    @JsonProperty("full_name")
    @JsonAlias({"name"})
    private String name;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "El correo electrónico no es válido.")
    private String email;

    //@NotBlank(message = "El correo es obligatorio.")
    private Role role;
    
}
