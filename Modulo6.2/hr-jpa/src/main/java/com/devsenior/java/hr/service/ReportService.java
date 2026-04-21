package com.devsenior.java.hr.service;

import java.util.List;

import com.devsenior.java.hr.model.entity.Employee;

public interface ReportService {

    List<Employee> getAllEmployees();

    List<Employee> getEmplyeesByDepartment(String department);

    List<Employee> getEmplyeesByCountry(String id);
    
}
