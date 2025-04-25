package com.devsenior.nmanja;

import com.devsenior.nmanja.entities.Department;
import com.devsenior.nmanja.entities.Location;

import jakarta.persistence.Persistence;

public class JpaDemo {

    public void dataTest(){
        var emf = Persistence.createEntityManagerFactory("hrPU");
        var em = emf.createEntityManager();

        var loc = new Location();

        loc.setId(1700);


        var dep = new Department();
        dep.setName("Mesa de ayuda");
        dep.setLocation(loc);

        em.getTransaction().begin();
        em.persist(dep);
        em.getTransaction().commit();

        /* System.out.println("Se ha creado el departamento con id: "+ dep.getDepartmentId()); */
        System.out.println("Se ha creado correctamente");
    }


    public void dataTest2(){
        var emf = Persistence.createEntityManagerFactory("hrPU");
        var em = emf.createEntityManager();


        var query = em.createQuery("SELECT d FROM Department d", Department.class);

        query.getResultList()
        .forEach(d -> System.out.printf("El departamento %s se encuentra en %s%n", d.getName(), d.getLocation().getCity()));

    }
}
