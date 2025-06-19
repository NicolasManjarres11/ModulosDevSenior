package com.devsenior.nmanja.course_security.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.course_security.exception.CourseNotFoundException;
import com.devsenior.nmanja.course_security.mapper.CourseMapper;
import com.devsenior.nmanja.course_security.model.dto.CourseDto;
import com.devsenior.nmanja.course_security.repository.CourseRepository;
import com.devsenior.nmanja.course_security.service.CourseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll()
        .stream()
        .map(courseMapper::entityToDto)
        .toList()
    ;
    }

    @Override
    public CourseDto getCourseById(Long id) {

        return courseRepository.findById(id)
        .map(courseMapper::entityToDto)
        .orElseThrow(() -> new CourseNotFoundException());
    }

    @Override
    public CourseDto addCourse(CourseDto course) {

        var entity = courseMapper.dtoToEntity(course);
        courseRepository.save(entity);
        return courseMapper.entityToDto(entity);
    }

    @Override
    public CourseDto deleteCourse(Long id) {
        if(!courseRepository.existsById(id)){
            throw new CourseNotFoundException();
        }

        var entity = courseRepository.findById(id).get();

        courseRepository.delete(entity);

        return courseMapper.entityToDto(entity);
    }





    
    
}
