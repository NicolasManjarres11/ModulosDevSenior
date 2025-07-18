package com.devsenior.nmanja.course_security.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsenior.nmanja.course_security.exception.CourseMappingException;
import com.devsenior.nmanja.course_security.exception.CourseNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice //Con esta etiqueta, indicamos que esta clase se va a encargar de capturar las excpeciones del controlador
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCourseNotFoundException(CourseNotFoundException ex, HttpServletRequest request) {

        var errorResponse = new ApiErrorResponse(
            HttpStatus.NOT_FOUND,
            ex.getMessage(), 
            request.getRequestURI()); //Devuelve el path o endpoint de la API

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(CourseMappingException.class)
    public ResponseEntity<ApiErrorResponse> handleCourseMappingException(CourseMappingException ex, HttpServletRequest request) {

        var errorResponse = new ApiErrorResponse(
            HttpStatus.CONFLICT,
            ex.getMessage(), 
            request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ApiErrorResponse> handleAuthorizationDeniedException(AuthorizationDeniedException ex, HttpServletRequest request) {

        log.info(ex.getClass().getName());
        var errorResponse = new ApiErrorResponse(
            HttpStatus.FORBIDDEN,
            ex.getMessage(), 
            request.getRequestURI());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleRunTimeException(RuntimeException ex, HttpServletRequest request) {

        log.info(ex.getClass().getName());
        var errorResponse = new ApiErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR,
            ex.getMessage(), 
            request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex, HttpServletRequest request) {

        var errorResponse = new ApiErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Ha ocurrido un error inesperado, intente más tarde.", 
            request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }



    
}
