package com.devsenior.nmanja.restful_project.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true, length = 10)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "initial_date", nullable = false)
    private LocalDate initialDate;

    @Column(name = "fianl_date")
    private LocalDate finalDate;

    @Column(name = "credit_number", nullable = false)
    private Integer credits;

}
