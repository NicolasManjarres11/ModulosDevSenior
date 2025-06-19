package com.devsenior.nmanja.course_security.service;

import java.util.List;

import com.devsenior.nmanja.course_security.model.dto.CourseDto;
import com.devsenior.nmanja.course_security.model.entity.Course;

public interface CourseService {

    List<CourseDto> getAllCourses(); 
    
    CourseDto getCourseById(Long id);
    
    CourseDto addCourse(CourseDto course);
    
     CourseDto deleteCourse(Long id);
    
}
