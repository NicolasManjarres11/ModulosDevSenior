package com.devsenior.nmanja.dao;

import java.util.List;

import com.devsenior.nmanja.entity.Employee;
import com.devsenior.nmanja.util.JpaUtil;

public class EmployeeDao {

    public void save(Employee employee){

        var em = JpaUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();

        em.close();

    }

    public List<Employee> findAll(){
        


        var em =JpaUtil.getEntityManager();

        var query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        var response = query.getResultList();
        

        em.close();

        return response;

    }

}
