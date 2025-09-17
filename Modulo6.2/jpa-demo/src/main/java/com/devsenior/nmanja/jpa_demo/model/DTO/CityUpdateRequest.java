package com.devsenior.nmanja.jpa_demo.model.DTO;

public class CityUpdateRequest {
    private String department;

    

    public CityUpdateRequest() {
    }

    

    public CityUpdateRequest(String department) {
        this.department = department;
    }



    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
