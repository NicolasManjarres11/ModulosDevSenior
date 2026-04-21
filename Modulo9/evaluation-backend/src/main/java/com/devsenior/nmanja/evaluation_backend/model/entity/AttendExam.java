package com.devsenior.nmanja.evaluation_backend.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "diligenciamiento")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AttendExam {

    @Id
    private String id;

    private User student;
    private Exam exam;
    private LocalDateTime attendDate;
    private boolean finished;

    @Data

    public static class Answer {
        private Question question;


        Double grade;
        String comment;
        boolean isGraded;
        
        private String openAnswer;
        private Question.Option optionAnswer;
    }
    
}
