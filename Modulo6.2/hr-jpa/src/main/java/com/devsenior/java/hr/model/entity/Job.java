package com.devsenior.java.hr.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jobs")
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer id;

    @Column(name = "job_title", length = 35, nullable = false)
    private String title;

    @Column //Precision es numero de digitos a guardar y el scale son cuantos numeros se muestran en el decimal
    private Double minSalary;

    @Column //Precision es numero de digitos a guardar y el scale son cuantos numeros se muestran en el decimal

    private Double maxSalary;
}
