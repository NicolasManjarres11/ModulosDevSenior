package com.devsenior.nmanja.evaluation_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.evaluation_backend.model.dto.ExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;
import com.devsenior.nmanja.evaluation_backend.service.StudentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<UserResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/exam/{teacher}")
    public List<ExamDTO> getActiveExamsByTeacher(@PathVariable Long teacher) {
        return studentService.getActiveExamsByTeacher(teacher);
    }
    
    @PostMapping("/exam")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
    
}
