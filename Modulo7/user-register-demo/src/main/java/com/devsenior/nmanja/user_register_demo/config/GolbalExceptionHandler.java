package com.devsenior.nmanja.user_register_demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsenior.nmanja.user_register_demo.exception.UserAlreadyExitsException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //Se reportan los manejos de los errores
public class GolbalExceptionHandler {

    @ExceptionHandler(UserAlreadyExitsException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyExist(UserAlreadyExitsException e, HttpServletRequest request){

        return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(new ApiErrorResponse(HttpStatus.CONFLICT, e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleRunTimeException(RuntimeException e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleRunTimeException(Exception e, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), request.getRequestURI()));
    }
    
}
