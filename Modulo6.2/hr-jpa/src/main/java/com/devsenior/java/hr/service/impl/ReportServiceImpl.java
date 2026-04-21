package com.devsenior.java.hr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.java.hr.model.entity.Employee;
import com.devsenior.java.hr.repository.EmployeeRepository;
import com.devsenior.java.hr.service.ReportService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService{

    private final EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmplyeesByDepartment(String department) {
        // TODO Auto-generated method stub
        return employeeRepository.findAllByDepartmentId(Integer.valueOf(department));
    }

    @Override
    public List<Employee> getEmplyeesByCountry(String id) {
        // TODO Auto-generated method stub
        return employeeRepository.findAllCountryId(id);
    }
}
