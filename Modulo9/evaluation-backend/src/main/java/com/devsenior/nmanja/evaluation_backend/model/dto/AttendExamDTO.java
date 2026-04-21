package com.devsenior.nmanja.evaluation_backend.model.dto;

import java.util.List;

import com.devsenior.nmanja.evaluation_backend.model.entity.Question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


public record AttendExamDTO(
    String id,
    Long studentCode,
    String examId,
    List<AnswerDto> answers
) {

    public record AnswerDto(
        QuestionDTO question,
        Double grade
    ) {

        public record QuestionDTO(
            @NotBlank(message = "El título de la pregunta es obligatorio")
            String title,
            String description,
            @NotBlank(message = "El tipo de pregunta es obligatorio")
            String type,
            @NotNull(message = "La calificación de la pregunta es obligatoria")
            Double grade,

            String openAnswer,

            OptionDto optionAnswer

            
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

    @Data
    public static class Answer {
        private String openAnswer;
        private Question.Option optionAnswer;
    }
    
}
