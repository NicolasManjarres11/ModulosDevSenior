package com.devsenior.nmanja.jpa_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsenior.nmanja.jpa_demo.model.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

    List<Teacher> findAllByCityNameContaining(String city);

    List<Teacher> findAllByFirstNameAndSecondNameAndLastnameAndSecondLastname(String firstName, String secondName, String lLastName, String SecondLastName);

    List<Teacher> findAllByFirstNameOrSecondNameOrLastnameOrSecondLastname(String firstName, String secondName, String lLastName, String SecondLastName);

    //@Query("SELECT t FROM Teacher t WHERE t.salary >= :salary ORDER BY t.lastname, t.firstName") //Consultas sobre las entidades  - - - - - >  JPQL
    @Query(value = "SELECT * FROM profesor WHERE sueldo >= :salary ORDER BY primer_apellido, primer_nombre", nativeQuery = true) //SQL 
    List<Teacher> lookingBySalary(Double salary);
    
}
