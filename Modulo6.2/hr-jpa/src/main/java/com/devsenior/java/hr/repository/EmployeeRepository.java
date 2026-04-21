package com.devsenior.java.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.devsenior.java.hr.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
    List<Employee> findAllByDepartmentId(Integer department);


    List<Employee> findAllByDepartmentLocationCountryId(String countryId);

/*     @Query(value = """
            SELECT E.*
            FROM employees E
            JOIN departments D USING (department_id)
            JOIN locations L USING (location_id)
            JOIN countries C USING (country_id)
            WHERE C.country_id = :countryId
            """, nativeQuery = true) */

    @Query("""
        SELECT e FROM Employee e 
        JOIN e.department d 
        JOIN d.location l
        JOIN l.country c
        WHERE c.id = :countryId
        """ ) //JPQL
    List<Employee> findAllCountryId(String countryId);


}
