package com.devsenior.nmanja.jpa_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.jpa_demo.model.DTO.TeacherCreateRequest;
import com.devsenior.nmanja.jpa_demo.model.DTO.TeacherResponse;
import com.devsenior.nmanja.jpa_demo.service.TeacherService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController (TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherResponse> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/by_city/{city}")
    public List<TeacherResponse> getByCity(@PathVariable String city) {
        return teacherService.getByCity(city);
    }

    @GetMapping("/by_name")
    public List<TeacherResponse> getByName(
        @RequestParam (required = false) String name1,
        @RequestParam (required = false) String name2,
        @RequestParam (required = false) String lastname1,
        @RequestParam (required = false) String lastname2
        )
    {
        return teacherService.getByName(name1, name2, lastname1, lastname2);
    }
    
    @GetMapping("/salary")
    public List<TeacherResponse> getBySalary(@RequestParam(defaultValue = "0") Double salary) {
        return teacherService.getBySalary(salary);
    }
    
    

    @PostMapping
    public TeacherResponse create(@RequestBody TeacherCreateRequest teacher) {
        
        return teacherService.create(teacher);
    }
    
    
    
}
