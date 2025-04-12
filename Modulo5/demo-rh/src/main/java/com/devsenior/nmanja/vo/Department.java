package com.devsenior.nmanja.vo;

public class Department {

    private Integer departmentId;
    private String departmentName;
    private Integer locationId;

    
    public Integer getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", locationId="
                + locationId + "]";
    }

    

}
