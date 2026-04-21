package com.devsenior.nmanja.evaluation_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.devsenior.nmanja.evaluation_backend.model.dto.ExamDTO;
import com.devsenior.nmanja.evaluation_backend.model.entity.Exam;
import com.devsenior.nmanja.evaluation_backend.model.entity.Question;
import com.devsenior.nmanja.evaluation_backend.model.entity.QuestionType;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    
    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);
    
    /**
     * Convierte Exam a ExamDTO
     */
    @Mapping(target = "questions", source = "questions")
    ExamDTO examToExamDTO(Exam exam);

    /**
     * Convierte ExamDTO a Exam
     */
    @Mapping(target = "questions", source = "questions")
    @Mapping(target = "teacher", ignore = true) // Se maneja por separado
    @Mapping(target = "subject", ignore = true) // No está en el DTO
    @Mapping(target = "description", ignore = true) // No está en el DTO
    Exam examDTOToExam(ExamDTO examDTO);
    
    /**
     * Convierte Question a QuestionDTO
     */
    @Mapping(target = "type", source = "questionType")
    ExamDTO.QuestionDTO questionToQuestionDTO(Question question);
    
    /**
     * Convierte QuestionDTO a Question
     */
    @Mapping(target = "questionType", source = "type")
    Question questionDTOToQuestion(ExamDTO.QuestionDTO questionDTO);
    
    /**
     * Convierte Question.Option a ExamDTO.QuestionDTO.OptionDto
     */
    Question.Option optionDTOToOption(ExamDTO.QuestionDTO.OptionDto optionDto);
    
    /**
     * Convierte ExamDTO.QuestionDTO.OptionDto a Question.Option
     */
    ExamDTO.QuestionDTO.OptionDto optionToOptionDTO(Question.Option option);
    
    /**
     * Convierte QuestionType enum a String
     */
    default String questionTypeToString(QuestionType questionType) {
        if (questionType == null) {
            return null;
        }
        return questionType.name();
    }
    
    /**
     * Convierte String a QuestionType enum
     */
    default QuestionType stringToQuestionType(String type) {
        if (type == null) {
            return null;
        }
        try {
            return QuestionType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
