package com.devsenior.nmanja.tutoria_services.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.tutoria_services.models.StudentDto;
import com.devsenior.nmanja.tutoria_services.repositories.GradeRepository;
import com.devsenior.nmanja.tutoria_services.repositories.StudentRepository;

@Service //El servicio trae la lógica del negocio
public class StudentService {

    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    public StudentService(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;

    }

    public List<StudentDto> getAll(){
        return studentRepository.findAll();
    }

    public StudentDto save(StudentDto student){

        if(student.getCode() == null){
            throw new RuntimeException("El campo Code es obligatorio");
        } else if(student.getName() == null || student.getName().isBlank()){
            throw new RuntimeException("El campo Nombre es obligatorio");
        } else if(student.getGenre() == null || student.getGenre().isBlank()){
            throw new RuntimeException("El campo Genero es obligatorio");
        }

        if(student.isActive() == null){
            student.setActive(true);
        }

        student.getGrades().stream()
            .map(g -> {
                g.setStudentCode(student.getCode());
                return g;
            })
            .forEach(gradeRepository::addGrade);

        student.setGrades(null);

        return studentRepository.save(student);
    }

    public StudentDto delete(Long code){

        if(code <1){
            throw new RuntimeException("El codigo enviado no es valido");
        }

        var student = studentRepository.delete(code);
        student.setGrades(gradeRepository.deleteGradeByStudentCode(code));

        return student;
    }

    public StudentDto findById(Long code){

        if(code < 1){
            throw new RuntimeException("Codigo invalido");
        }

        var student = studentRepository.findById(code);
        student.setGrades(gradeRepository.findGradeByStudentCode(code));
        

        return student;
    }
    

}
