package com.devsenior.nmanja.evaluation_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.devsenior.nmanja.evaluation_backend.model.dto.AttendExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.entity.AttendExam;
import com.devsenior.nmanja.evaluation_backend.model.entity.Question;

@Mapper(componentModel = "spring")
public interface AttendExamMapper {
    
    AttendExamMapper INSTANCE = Mappers.getMapper(AttendExamMapper.class);
    
    /**
     * Convierte AttendExam a AttendExamDTO
     * Nota: AttendExam no tiene campo answers, se maneja por separado
     */
    @Mapping(target = "studentCode", source = "student.code")
    @Mapping(target = "examId", source = "exam.id")
    @Mapping(target = "answers", ignore = true) // Se maneja por separado
    AttendExamDTO attendExamToAttendExamDTO(AttendExam attendExam);

    /**
     * Convierte AttendExamDTO a AttendExam
     */
    @Mapping(target = "student", ignore = true) // Se maneja por separado
    @Mapping(target = "exam", ignore = true) // Se maneja por separado
    @Mapping(target = "attendDate", ignore = true) // Se establece automáticamente
    @Mapping(target = "finished", ignore = true) // Se establece automáticamente
    AttendExam attendExamDTOToAttendExam(AttendExamDTO attendExamDTO);
    
    /**
     * Convierte AttendExam.Answer a AttendExamDTO.AnswerDto
     */
    @Mapping(target = "question", source = "question")
    @Mapping(target = "grade", source = "grade")
    AttendExamDTO.AnswerDto answerToAnswerDto(AttendExam.Answer answer);
    
    /**
     * Convierte AttendExamDTO.AnswerDto a AttendExam.Answer
     */
    @Mapping(target = "question", source = "question")
    @Mapping(target = "grade", source = "grade")
    @Mapping(target = "comment", ignore = true) // No está en el DTO
    @Mapping(target = "graded", ignore = true) // Se establece automáticamente
    @Mapping(target = "openAnswer", ignore = true) // Se maneja por separado
    @Mapping(target = "optionAnswer", ignore = true) // Se maneja por separado
    AttendExam.Answer answerDtoToAnswer(AttendExamDTO.AnswerDto answerDto);
    
    /**
     * Convierte Question a AttendExamDTO.AnswerDto.QuestionDTO
     */
    @Mapping(target = "type", source = "questionType", qualifiedByName = "attendExamQuestionTypeToString")
    @Mapping(target = "openAnswer", ignore = true) // Se establece por separado
    @Mapping(target = "optionAnswer", ignore = true) // Se establece por separado
    AttendExamDTO.AnswerDto.QuestionDTO questionToQuestionDTO(Question question);
    
    /**
     * Convierte AttendExamDTO.AnswerDto.QuestionDTO a Question
     */
    @Mapping(target = "questionType", source = "type", qualifiedByName = "attendExamStringToQuestionType")
    @Mapping(target = "options", ignore = true) // No está en el DTO
    Question questionDTOToQuestion(AttendExamDTO.AnswerDto.QuestionDTO questionDTO);
    
    /**
     * Convierte Question.Option a AttendExamDTO.AnswerDto.QuestionDTO.OptionDto
     */
    AttendExamDTO.AnswerDto.QuestionDTO.OptionDto optionToOptionDto(Question.Option option);
    
    /**
     * Convierte AttendExamDTO.AnswerDto.QuestionDTO.OptionDto a Question.Option
     */
    Question.Option optionDtoToOption(AttendExamDTO.AnswerDto.QuestionDTO.OptionDto optionDto);
    
    /**
     * Convierte QuestionType enum a String para AttendExam
     */
    @Named("attendExamQuestionTypeToString")
    default String attendExamQuestionTypeToString(com.devsenior.nmanja.evaluation_backend.model.entity.QuestionType questionType) {
        if (questionType == null) {
            return null;
        }
        return questionType.name();
    }
    
    /**
     * Convierte String a QuestionType enum para AttendExam
     */
    @Named("attendExamStringToQuestionType")
    default com.devsenior.nmanja.evaluation_backend.model.entity.QuestionType attendExamStringToQuestionType(String type) {
        if (type == null) {
            return null;
        }
        try {
            return com.devsenior.nmanja.evaluation_backend.model.entity.QuestionType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
