package com.devsenior.nmanja.course_security.mapper;

import org.springframework.stereotype.Component;

import com.devsenior.nmanja.course_security.exception.CourseMappingException;
import com.devsenior.nmanja.course_security.model.dto.CourseDto;
import com.devsenior.nmanja.course_security.model.entity.Course;

@Component //Crea un objeto y lo guarda en memoria para utilizarlo luego
public class CourseMapper {

    public CourseDto entityToDto(Course course){
        if (course == null) {
            throw new CourseMappingException("La entidad no está asignada correctamente");
        }
        var dto = new CourseDto();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        return dto;
    }

    public Course dtoToEntity(CourseDto courseDto){
        if (courseDto == null) {
            throw new CourseMappingException("El DTO no está asignada correctamente");
        }
        var course = new Course();
        course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        return course;
    }
    
}
