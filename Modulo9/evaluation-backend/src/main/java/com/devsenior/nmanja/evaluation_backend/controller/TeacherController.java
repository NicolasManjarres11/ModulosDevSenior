package com.devsenior.nmanja.evaluation_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.evaluation_backend.model.dto.ExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;
import com.devsenior.nmanja.evaluation_backend.service.TeacherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")

public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/{code}/exams")
    public List<ExamDTO> myExams(@PathVariable Long code){
        return teacherService.listExams(code);
    }

    @GetMapping
    public List<UserResponseDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
    

    @PostMapping("/{code}/exams")
    public ExamDTO createExam(@PathVariable Long code, @Valid @RequestBody ExamDTO exam) {
        
        return teacherService.createExam(code, exam);
    }


    
    
}