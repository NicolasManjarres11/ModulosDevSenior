package com.devsenior.nmanja.course_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.course_security.model.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{
    
}
