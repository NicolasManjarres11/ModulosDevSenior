package com.devsenior.nmanja.evaluation_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsenior.nmanja.evaluation_backend.model.entity.AttendExam;

public interface AttendExamRepository extends MongoRepository<AttendExam, String>{
    
}
