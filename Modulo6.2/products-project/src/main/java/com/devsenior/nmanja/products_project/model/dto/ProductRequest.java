package com.devsenior.nmanja.products_project.model.dto;

import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequest {
    
    @NotBlank(message = "El nombre del producto es obligatorio.")
    private String name;

    @NotBlank(message = "El precio del producto es obligatorio.")
    @Size(min = 10000, message = "El precio debe ser mayor a 10000.")
    private Double price;

    @NotBlank(message = "La descripción del producto es obligatorio.")
    @Length(min = 15, message = "La descripción debe tener como mínimo 15 carácteres." )
    private String description;

    @NotEmpty(message = "El etiquetado del producto es obligatorio.")
    private List<String> tags;

    @NotBlank(message = "Las especificaciones del producto son obligatorias.")
    private Map<String, Object> specifications;
}
