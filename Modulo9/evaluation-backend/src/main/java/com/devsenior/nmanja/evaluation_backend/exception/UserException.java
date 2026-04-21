package com.devsenior.nmanja.evaluation_backend.exception;

/**
 * Excepción simple para todos los errores relacionados con usuarios
 */
public class UserException extends RuntimeException {
    
    public UserException(String message) {
        super(message);
    }
}

