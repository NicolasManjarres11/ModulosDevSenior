package com.devsenior.java.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.java.hr.model.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
}
