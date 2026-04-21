package com.devsenior.java.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.java.hr.model.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{
    
}
