package com.devsenior.nmanja.evaluation_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsenior.nmanja.evaluation_backend.model.entity.Exam;

public interface ExamRepository extends MongoRepository<Exam, String> {
    
    List<Exam> findAllByTeacherCode(Long teacher);
}
