package com.devsenior.nmanja.evaluation_backend.service;

import java.util.List;

import com.devsenior.nmanja.evaluation_backend.model.dto.AttendExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.dto.ExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;

public interface StudentService {
    
    List<UserResponseDto> getAllStudents();

    List<ExamDTO> getActiveExamsByTeacher(Long teacher);

    void attendExam(AttendExamDTO exam);
}
