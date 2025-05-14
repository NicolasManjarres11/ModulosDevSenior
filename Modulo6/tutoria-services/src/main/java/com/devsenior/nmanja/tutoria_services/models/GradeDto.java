package com.devsenior.nmanja.tutoria_services.models;

public class GradeDto {

    private Long studentCode;
    private String name;
    private Double grade;

    
    public GradeDto() {
    }

    

    public GradeDto(Long studentCode, String name, Double grade) {
        this.studentCode = studentCode;
        this.name = name;
        this.grade = grade;
    }



    public Long getStudentCode() {
        return studentCode;
    }


    public void setStudentCode(Long studentCode) {
        this.studentCode = studentCode;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Double getGrade() {
        return grade;
    }


    public void setGrade(Double grade) {
        this.grade = grade;
    }

    

}
