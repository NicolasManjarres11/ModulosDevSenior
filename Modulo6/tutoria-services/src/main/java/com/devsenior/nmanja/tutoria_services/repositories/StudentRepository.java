package com.devsenior.nmanja.tutoria_services.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsenior.nmanja.tutoria_services.models.StudentDto;

@Repository
public class StudentRepository {

    private List<StudentDto> students;

    public StudentRepository(){
        students = new ArrayList<>();
    }

    public List<StudentDto> findAll(){

        return students;
    }

    public StudentDto save(StudentDto student){
        students.add(student);
        return student;
    }

    public StudentDto delete(Long code){
        var student = students.stream().
            filter(s -> s.getCode().longValue() == code).
            findFirst().
            get();


        students.remove(student);

        return student;
    }


    public StudentDto findById(Long code){

        var student = students.stream()
        .filter(s -> s.getCode().longValue() == code)
        .findFirst()
        .get();

        return student;

    }

}
