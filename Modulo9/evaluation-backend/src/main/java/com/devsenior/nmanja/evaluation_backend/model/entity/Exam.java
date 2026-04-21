package com.devsenior.nmanja.evaluation_backend.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "examenes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Exam {

    @Id
    private String id;

    private User teacher;
    private String title;
    private String subject;
    private String description;
    private LocalDateTime initialDateTime;
    private LocalDateTime finalDateTime;

    private List<Question> questions;
    
}
