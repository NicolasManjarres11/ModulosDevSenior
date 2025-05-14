package com.devsenior.nmanja.tutoria_services.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.devsenior.nmanja.tutoria_services.models.GradeDto;

@Repository
public class GradeRepository {
    
    private Map<Long, List<GradeDto>> grades;

    public GradeRepository(){
        grades = new HashMap<>();
    }

    public void addGrade(GradeDto grade){
        var studentGrades = grades.get(grade.getStudentCode());
        if(studentGrades == null){
            studentGrades = new ArrayList<>();
            grades.put(grade.getStudentCode(), studentGrades);
        }
        studentGrades.add(grade);
    }

    public List<GradeDto> findGradeByStudentCode(Long studentCode){
        return grades.get(studentCode);
    }
    
    public List<GradeDto> deleteGradeByStudentCode(Long studentCode){
        return grades.remove(studentCode);
    }

}
