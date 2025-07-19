package com.devsenior.nmanja.restful_project.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.restful_project.models.dto.CourseRequest;
import com.devsenior.nmanja.restful_project.models.dto.CourseResponse;
import com.devsenior.nmanja.restful_project.services.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@Tag(name = "Cursos", description = "Endpoint para gestionar los cursos de la academia")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cursos")
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "Listar todos los cursos", description = "Lista todos los cursos activos e inactivos del sistema")
    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getOne(id);
    }

    @GetMapping("buscar")
    public List<CourseResponse> getCourseByName(@RequestParam("nombre") String name) {
        return courseService.getByName(name);
    }

    @PostMapping
    public CourseResponse createCourse(
        
        @Valid
        @RequestBody
        CourseRequest course) {
        
        
        return courseService.create(course);
    }
    
    @PutMapping("{id}")
    public CourseResponse updateCourse(@PathVariable Long id,@RequestBody CourseRequest course) {
        
        
        return courseService.update(id, course);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.delete(id);
    }
    
    
    
    
}
