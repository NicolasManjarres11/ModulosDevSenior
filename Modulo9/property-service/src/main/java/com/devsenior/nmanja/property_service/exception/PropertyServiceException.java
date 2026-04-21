package com.devsenior.nmanja.property_service.exception;

public class PropertyServiceException extends RuntimeException {
    
    public PropertyServiceException(String message) {
        super(message);
    }
    
    public PropertyServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
