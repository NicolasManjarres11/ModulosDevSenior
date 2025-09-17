package com.devsenior.nmanja.jpa_demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Teacher {

    @Id
    @Column(name = "documento")
    private Integer document;

    @Column(name = "primer_nombre", nullable = false, length = 50)
    private String firstName;

    @Column(name = "segundo_nombre", length = 50)
    private String secondName;

    @Column(name = "primer_apellido", nullable = false, length = 50)
    private String lastname;

    @Column(name = "segundo_apellido", length = 50)
    private String secondLastname;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "prefijo", length = 7)
    private String indicative;

    @Column(name = "telefono", nullable = false, unique = true ,length = 10)
    private String phoneNumber;

    @Column(name = "direccion", nullable = false, length = 200)
    private String address;

    @Column(name = "direccion_adicional", length = 200)
    private String aditionalAddress;

    //@Column(name = "ciudad", nullable = false, length = 25 )
    @ManyToOne
    @JoinColumn(name = "ciudad", referencedColumnName = "nombre", nullable = false)
    private City city;

    @Column(name = "sueldo", nullable = false)
    private Integer salary;



    

    public Teacher() {
    }

    

    public Teacher(Integer document, String firstName, String secondName, String lastname, String secondLastname,
            String email, String indicative, String phoneNumber, String address, String aditionalAddress, City city,
            Integer salary) {
        this.document = document;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastname = lastname;
        this.secondLastname = secondLastname;
        this.email = email;
        this.indicative = indicative;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.aditionalAddress = aditionalAddress;
        this.city = city;
        this.salary = salary;
    }



    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndicative() {
        return indicative;
    }

    public void setIndicative(String indicative) {
        this.indicative = indicative;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAditionalAddress() {
        return aditionalAddress;
    }

    public void setAditionalAddress(String aditionalAddress) {
        this.aditionalAddress = aditionalAddress;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    
    
}
