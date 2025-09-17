package com.devsenior.nmanja.jpa_demo.model.DTO;

public class TeacherCreateRequest {
        
    private Integer document;
    private String firstName;
    private String secondName;
    private String lastname;
    private String secondLastname;
    private String email;
    private String indicative;
    private String phoneNumber;
    private String address;
    private String aditionalAddress;
    private String city;
    private Integer salary;




    
    public TeacherCreateRequest() {
    }

    

    public TeacherCreateRequest(Integer document, String firstName, String secondName, String lastname,
            String secondLastname, String email, String indicative, String phoneNumber, String address,
            String aditionalAddress, String city, Integer salary) {
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
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    
}
