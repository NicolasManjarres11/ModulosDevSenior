package com.devsenior.nmanja;

import com.devsenior.nmanja.dao.DepartmentDao;
import com.devsenior.nmanja.dao.EmployeesDao;
import com.devsenior.nmanja.vo.Department;
import com.devsenior.nmanja.vo.Employee;

public class Main {
    public static void main(String[] args){

        var employee = new Employee();
        var employeDao = new EmployeesDao();

        var departmentDao = new DepartmentDao();
        var department = new Department();




      
        /* Prueba save */
        
/*         employee.setFirstName("Dayana");
        employee.setLastName("Medina");
        employee.setEmail("dayis@gmail.es");
        employee.setPhonenumber("7777777");
        employee.setHireDate("2023-08-27");
        employee.setJobId(17);
        employee.setSalary(18000);
        employee.setManagerId(100);
        employee.setDepartmentId(10);  */

        /* employeDao.save(employee); */

        /* //Prueba Update

        employee.setPhonenumber("3192842215");
        employee.setSalary(45890);
        employee.setJobId(17);

        department.setDepartmentName("Administración");
        department.setLocationId(1700);


        departmentDao.update(1, department);
        employeDao.update(3, employee);

 */

        

    }

    public static void saveEmployee(Employee employee, EmployeesDao employeDao){

        
        
        employee.setFirstName("Dayana");
        employee.setLastName("Medina");
        employee.setEmail("dayis@gmail.es");
        employee.setPhonenumber("7777777");
        employee.setHireDate("2023-08-27");
        employee.setJobId(17);
        employee.setSalary(18000);
        employee.setManagerId(100);
        employee.setDepartmentId(10);
        employeDao.save(employee);
    }

    public static void saveDepartment(){

        var departmentDao = new DepartmentDao();
        var department = new Department();

        department.setDepartmentName("Tecnología");
        department.setLocationId(2500);

        departmentDao.save(department);
    }

    public static void updateUser(Employee employee, EmployeesDao employeDao){



    }

}