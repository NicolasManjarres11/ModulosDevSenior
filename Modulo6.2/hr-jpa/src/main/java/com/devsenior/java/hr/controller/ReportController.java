package com.devsenior.java.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.java.hr.model.entity.Employee;
import com.devsenior.java.hr.service.ReportService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hr/reports")
public class ReportController {
    
    private final ReportService reportService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return reportService.getAllEmployees();
    }

    @GetMapping("/employees/department")
    public List<Employee> getEmplyeesByDepartment(@RequestParam String department) {
        return reportService.getEmplyeesByDepartment(department);
    }
    @GetMapping("/employees/country")
    public List<Employee> getEmplyeesByCountry(@RequestParam String id) {
        return reportService.getEmplyeesByCountry(id);
    }
    


}
