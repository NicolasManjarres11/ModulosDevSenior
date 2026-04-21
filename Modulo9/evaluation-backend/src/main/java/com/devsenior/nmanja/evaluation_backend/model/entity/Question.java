package com.devsenior.nmanja.evaluation_backend.model.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Question {
    
    String title;
    String description;
    Double grade;
    private QuestionType questionType;

    private List<Option> options;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Option {
        String description;
        boolean isAnswer;
    }

}


