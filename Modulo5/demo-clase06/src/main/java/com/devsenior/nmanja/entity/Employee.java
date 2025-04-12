package com.devsenior.nmanja.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



// VO - Value Object
// DTO - Data Transfer Object
// POJO - Plain Old Java Object


@Entity
@Table(name = "employees") //Se mapea clase con la BD

public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column (name = "first_name", length = 20)
    private String firstName;

    @Column (name="last_name",length = 25, nullable=false)
    private String lastName;

    @Column (name="email",length=100,nullable=false)
    private String email;

    @Column (name="phone_number",length=100)
    private String phoneNumber;

    
    @Column (name="hire_date",nullable=false)
    private LocalDate hireDate;

    @Column(name="job_id") 
    private Integer jobId;

    @Column (name="salary",precision=2, nullable=false)
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "manager_id",referencedColumnName="employee_id")
    private Employee managerId;

    @ManyToOne
    @JoinColumn(name="department_id", referencedColumnName="department_id") //Employee --- Department
    private Department department;


    


    public Integer getEmployeeId() {
        return employeeId;
    }





    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }





    public String getFirstName() {
        return firstName;
    }





    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }





    public String getLastName() {
        return lastName;
    }





    public void setLastName(String lastName) {
        this.lastName = lastName;
    }





    public String getEmail() {
        return email;
    }





    public void setEmail(String email) {
        this.email = email;
    }





    public String getPhoneNumber() {
        return phoneNumber;
    }





    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }





    public LocalDate getHireDate() {
        return hireDate;
    }





    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }





    public Integer getJobId() {
        return jobId;
    }





    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }





    public Double getSalary() {
        return salary;
    }





    public void setSalary(Double salary) {
        this.salary = salary;
    }





    public Employee getManagerId() {
        return managerId;
    }





    public void setManagerId(Employee managerId) {
        this.managerId = managerId;
    }





    public Department getDepartment() {
        return department;
    }





    public void setDepartment(Department department) {
        this.department = department;
    }





    @Override
    public String toString() {
        return "Soy el empleado " + lastName
                + " y mi departamento se llama " + department.getName()
                + (managerId != null ? 
                " y mi jefe es " + managerId.getLastName() 
                : 
                " y soy el Jefe");
    }

}
