package com.devsenior.nmanja.evaluation_backend.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record ExamDTO(

    String id,

    @NotBlank(message = "El titulo es obligatorio")
    String title,

    @NotBlank(message = "La descripción es obligatoria")
    String description,


    @NotNull(message = "La fecha inicial es obligatoria")
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime initialDateTime,

    @NotNull(message = "La fecha final es obligatoria")
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime finalDateTime,
    
    @NotNull(message = "Las preguntas son obligatorias")
    @NotEmpty(message = "Debe incluir al menos una pregunta")
    List<QuestionDTO> questions

) {

    public record QuestionDTO(
        @NotBlank(message = "El título de la pregunta es obligatorio")
        String title,
        String description,
        @NotBlank(message = "El tipo de pregunta es obligatorio")
        String type,
        @NotNull(message = "La calificación de la pregunta es obligatoria")
        Double grade,
        List<OptionDto> options
    ){

        public record OptionDto(
        @NotBlank(message = "La descripción de la opción es obligatoria")
        String description,
        @NotNull(message = "Debe especificar si la opción es la respuesta correcta")
        boolean isAnswer
        ){

        }
        
    }
    
}
