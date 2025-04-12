package com.devsenior.nmanja.vo;

public class Employee {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phonenumber;
    private String hireDate;
    private Integer jobId;
    private Integer salary;
    private Integer managerId;
    private Integer departmentId;


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
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    public Integer getJobId() {
        return jobId;
    }
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public Integer getManagerId() {
        return managerId;
    }
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{");
        sb.append("employeeId=").append(employeeId);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", hireDate=").append(hireDate);
        sb.append(", jobId=").append(jobId);
        sb.append(", salary=").append(salary);
        sb.append(", managerId=").append(managerId);
        sb.append(", departmentId=").append(departmentId);
        sb.append('}');
        return sb.toString();
    }

    



}
