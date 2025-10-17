package com.devsenior.nmanja.restful_project.models.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Respuesta de la información completa de los cursos") //Documentacion de API Swagger 
@Data

public class CourseResponse {

    @Schema(description = "Identificador unico del curso", example = "1")
    private Long courseId;

    @Schema(description = "Nombre del curso", example = "Programacion Basica")
    private String name;

    private String code;

    private String description;

    
    private String inicialDate;

    private String finalDate;

    private Integer creditsNum;
    
}
