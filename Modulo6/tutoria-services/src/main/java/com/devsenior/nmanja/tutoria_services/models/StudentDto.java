package com.devsenior.nmanja.tutoria_services.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


public class StudentDto {

    private Long code;
    private String name;
    private Integer age;
    private String genre;
    private Boolean active;

    private List<GradeDto> grades;

    

    public StudentDto() {

        grades = new ArrayList<>();
    }

    public StudentDto(Long code, String name, Integer age, String genre, boolean active) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.genre = genre;
        this.active = active;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<GradeDto> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDto> grades) {
        this.grades = grades;
    }

    

    

}
