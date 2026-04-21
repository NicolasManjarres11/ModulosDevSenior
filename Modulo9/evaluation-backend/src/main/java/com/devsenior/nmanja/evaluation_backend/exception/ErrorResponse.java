package com.devsenior.nmanja.evaluation_backend.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Respuesta simple para errores de la API
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    
    /**
     * Código de estado HTTP
     */
    private int status;
    
    /**
     * Tipo de error
     */
    private String error;
    
    /**
     * Mensaje descriptivo del error
     */
    private String message;
}
