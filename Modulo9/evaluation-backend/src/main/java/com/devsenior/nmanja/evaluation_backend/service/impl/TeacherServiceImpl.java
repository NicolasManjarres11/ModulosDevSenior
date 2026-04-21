package com.devsenior.nmanja.evaluation_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.evaluation_backend.exception.UserException;
import com.devsenior.nmanja.evaluation_backend.mapper.ExamMapper;
import com.devsenior.nmanja.evaluation_backend.mapper.UserMapper;
import com.devsenior.nmanja.evaluation_backend.model.dto.ExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;
import com.devsenior.nmanja.evaluation_backend.model.entity.Role;
import com.devsenior.nmanja.evaluation_backend.repository.ExamRepository;
import com.devsenior.nmanja.evaluation_backend.repository.UserRepository;
import com.devsenior.nmanja.evaluation_backend.service.TeacherService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService{

    private final ExamRepository examRepository;
    private final ExamMapper examMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<ExamDTO> listExams(Long teacher) {

        userRepository.findByCode(teacher)
        .orElseThrow(() -> new UserException(String.format("No se encontró el profesor con id '%d'", teacher)));

    return examRepository.findAllByTeacherCode(teacher)
        .stream()
        .map(examMapper::examToExamDTO)
        .toList();

    }

    @Override
    public List<UserResponseDto> getAllTeachers() {
        
        return userRepository.findAllByRole(Role.TEACHER).stream()
            .map(userMapper::userToUserResponseDto)
            .toList();
    }
    
    @Override
    public ExamDTO createExam(Long teacher, ExamDTO exam) {
        
        var user = userRepository.findByCode(teacher)
            .orElseThrow(() ->  new UserException(String.format("No se encontró el profesor con id '%d'", teacher)));

        var examEntity = examMapper.examDTOToExam(exam);

        examEntity.setTeacher(user);

        var newExam = examRepository.save(examEntity);

        return examMapper.examToExamDTO(newExam);
    }
}
