package com.devsenior.nmanja.evaluation_backend.service;

import java.util.List;

import com.devsenior.nmanja.evaluation_backend.model.dto.ExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;

public interface TeacherService {
    
    List<ExamDTO> listExams(Long teacher);

    ExamDTO createExam(Long teacher, ExamDTO exam);

    List<UserResponseDto> getAllTeachers();
}