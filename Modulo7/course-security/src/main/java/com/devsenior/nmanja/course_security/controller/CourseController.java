package com.devsenior.nmanja.course_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.course_security.model.dto.CourseDto;
import com.devsenior.nmanja.course_security.service.CourseService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequiredArgsConstructor
@RequestMapping("/api/cursos")
@RestController

public class CourseController {

    private final CourseService courseService;

    
    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAllCourses();
    }

    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public CourseDto create(@RequestBody CourseDto course) {

        return courseService.addCourse(course);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public CourseDto delete(@PathVariable Long id){

        return courseService.deleteCourse(id);
    }
    
    
    
    
}
