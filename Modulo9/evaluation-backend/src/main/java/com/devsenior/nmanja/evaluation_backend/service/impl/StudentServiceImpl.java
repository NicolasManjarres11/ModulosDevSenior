package com.devsenior.nmanja.evaluation_backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.evaluation_backend.exception.UserException;
import com.devsenior.nmanja.evaluation_backend.mapper.AttendExamMapper;
import com.devsenior.nmanja.evaluation_backend.mapper.ExamMapper;
import com.devsenior.nmanja.evaluation_backend.mapper.UserMapper;
import com.devsenior.nmanja.evaluation_backend.model.dto.AttendExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.dto.ExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.dto.UserResponseDto;
import com.devsenior.nmanja.evaluation_backend.model.entity.Role;
import com.devsenior.nmanja.evaluation_backend.repository.AttendExamRepository;
import com.devsenior.nmanja.evaluation_backend.repository.ExamRepository;
import com.devsenior.nmanja.evaluation_backend.repository.UserRepository;
import com.devsenior.nmanja.evaluation_backend.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final ExamRepository examRepository;

    private final UserRepository userRepository;
    private final AttendExamRepository attendExamRepository;
    private final AttendExamMapper attendExamMapper;

    private final ExamMapper examMapper;
    private final UserMapper userMapper;



    @Override
    public List<UserResponseDto> getAllStudents() {
        
        return userRepository.findAllByRole(Role.STUDENT).stream()
            .map(userMapper::userToUserResponseDto)
            .toList();
    }

    @Override
    public List<ExamDTO> getActiveExamsByTeacher(Long teacher) {

        var now = LocalDateTime.now();
        return examRepository.findAllByTeacherCode(teacher).stream()
                .filter(exam -> exam.getInitialDateTime().isBefore(now) && exam.getFinalDateTime().isAfter(now))
                .map(examMapper::examToExamDTO)
                .toList();
    }

    @Override
    public void attendExam(AttendExamDTO attendExam) {

        var student = userRepository.findByCode(attendExam.studentCode())
        .orElseThrow(() ->  new UserException(String.format("No se encontró el estudiante con id '%d'", attendExam.studentCode())) );

        var exam = examRepository.findById(attendExam.examId())
        .orElseThrow(() ->  new UserException(String.format("No se encontró el examen con id '%d'", attendExam.studentCode())) );


        var attendExamEntity = attendExamMapper.attendExamDTOToAttendExam(attendExam);
        attendExamEntity.setStudent(student);
        attendExamEntity.setExam(exam);

        attendExamRepository.save(attendExamEntity);
        
    }
    
}
