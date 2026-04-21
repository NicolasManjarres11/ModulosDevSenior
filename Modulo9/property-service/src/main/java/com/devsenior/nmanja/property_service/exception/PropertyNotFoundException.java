package com.devsenior.nmanja.property_service.exception;

public class PropertyNotFoundException extends RuntimeException {
    
    public PropertyNotFoundException(String message) {
        super(message);
    }
    
    public PropertyNotFoundException(Long id) {
        super("Propiedad no encontrada con ID: " + id);
    }
    
    public PropertyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
