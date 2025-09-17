package com.devsenior.nmanja.jpa_demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ciudad")
public class City {

    public City(){

    }

    
    
    public City(String name) {
        this.name = name;
    }



    public City(String name, String department) {
        this.name = name;
        this.department = department;
    }



    @Id
    @Column(name = "nombre", length = 25)
    private String name;

    @Column(name = "departamento", length = 100)
    private String department;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }



}
