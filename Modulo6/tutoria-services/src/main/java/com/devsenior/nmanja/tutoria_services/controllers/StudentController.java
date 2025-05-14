package com.devsenior.nmanja.tutoria_services.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.tutoria_services.models.StudentDto;
import com.devsenior.nmanja.tutoria_services.services.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/students")
public class StudentController {

    
    private final StudentService studentService; //Se asegura que solo se inicializa una vez

    public StudentController(StudentService studentService){ //Con este estándar, nos facilita realizar las pruebas unitarias
        this.studentService = studentService;    
    }


    @GetMapping
    public List<StudentDto> getAllStudent() {
        
        return studentService.getAll();
    }

    @GetMapping("/{code}")
    public StudentDto getStudentById(@PathVariable Long code) {
        return studentService.findById(code);
    }
    
    
    @PostMapping
    public StudentDto newStudent(@RequestBody StudentDto student) {
        
        
        
        return studentService.save(student);
    }

    @DeleteMapping("/{code}")
    public StudentDto removeStudent(@PathVariable Long code){
        
        return studentService.delete(code);
    }
    


}
