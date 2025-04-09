package com.devsenior.nmanja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.devsenior.nmanja.vo.Employee;

public class EmployeeDao {

    

    //Data Access only

    public void savemployee(Employee employee){

        var url = "jdbc:postgresql://localhost:5432/RH";
        var user = "postgres";
        var password = "admin123";

        try{
        Connection conn = DriverManager.getConnection(url,user,password);

        var stmnt = conn.createStatement();

        
        var format = "INSERT INTO public.employees\n" + //
                        "(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id)\n" + //
                        "VALUES(nextval('employees_employee_id_seq'::regclass), '%s', '%s', '%s', '%s', '%s', %d, %d, %d, %d);";

        var sql = String.format(format, 
            employee.getFirstName(), 
            employee.getLastName(), 
            employee.getEmail(), 
            employee.getPhoneNumber(), 
            "2025-01-01",//employee.getHireDate(), 
            employee.getJobId(), 
            employee.getSalary(), 
            employee.getManagerId(), 
            employee.getDepartmentId());


        stmnt.execute(sql);


        stmnt.close();
        conn.close();

        System.out.println("Usuario guardado");
        
    } catch(SQLException e){
        System.out.println("Error al guardar el usuario "+ e.getMessage());

    }
    
    }

    public void updateEmployee(Integer id, Employee employee){

        var url = "jdbc:postgresql://localhost:5432/RH";
        var user = "postgres";
        var password = "admin123";

        try(Connection conn = DriverManager.getConnection(url,user,password);

        var stmnt = conn.createStatement()){
        

        
        var format = /* "UPDATE public.employees\n" + //

                        "SET first_name = '%s', last_name = '%s', email = '%s', phone_number = '%s', hire_date = '%s', job_id = %d, salary = %d, manager_id = %d, department_id = %d\n" + //
                        "(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id)\n" + //
                        "VALUES(nextval('employees_employee_id_seq'::regclass), '%s', '%s', '%s', '%s', '%s', %d, %d, %d, %d);" */
                        
                        """
                                UPDATE public.employees
                                SET first_name = '%s', 
                                last_name = '%s', 
                                email = '%s', 
                                phone_number = '%s', 
                                hire_date = '%s', 
                                job_id = %d, 
                                salary = %d, 
                                manager_id = %d, 
                                department_id = %d
                                WHERE employee_id = %d
                                """;

        var sql = String.format(format, 
            employee.getFirstName(), 
            employee.getLastName(), 
            employee.getEmail(), 
            employee.getPhoneNumber(), 
            "2025-04-08",//employee.getHireDate(), 
            employee.getJobId(), 
            employee.getSalary(), 
            employee.getManagerId(), 
            employee.getDepartmentId(),
            id);


        stmnt.execute(sql);


        System.out.println("Usuario actualizado");
        
    } catch(SQLException e){
        System.out.println("Error al actualizar el usuario "+ e.getMessage());

    }

    }

    public void deleteEmployee(Integer id){

        var url = "jdbc:postgresql://localhost:5432/RH";
        var user = "postgres";
        var password = "admin123";

        try(
            
        Connection conn = DriverManager.getConnection(url,user,password);
        var stmnt = conn.prepareStatement("Delete from Employees where employee_id = ?")){

            stmnt.setInt(1, id);
            stmnt.execute();

                

        System.out.println("Usuario eliminado");
        
    } catch(SQLException e){
        System.out.println("Error al eliminar el usuario "+ e.getMessage());
    }


}

    public List<Employee> findAllEmployees(){

        var employees = new ArrayList<Employee>();

        var url = "jdbc:postgresql://localhost:5432/RH";
        var user = "postgres";
        var password = "admin123";

        try(
            
        Connection conn = DriverManager.getConnection(url,user,password);
        var stmnt = conn.prepareStatement("select * from Employees");
        var rset =stmnt.executeQuery();

        ){

            while(rset.next()){
                var employee = new Employee();

                employee.setEmployeeId(rset.getInt("employee_id"));
                employee.setFirstName(rset.getString("first_name"));
                employee.setLastName(rset.getString("last_name"));
                employee.setEmail(rset.getString("email"));
                employee.setPhoneNumber(rset.getString("phone_number"));
                employee.setHireDate(rset.getDate("hire_date").toLocalDate());
                employee.setJobId(rset.getInt("job_id"));
                employee.setSalary(rset.getInt("salary"));
                employee.setManagerId(rset.getInt("manager_id"));
                employee.setDepartmentId(rset.getInt("department_id"));

                employees.add(employee);

            }

        System.out.println("Empleados listados correctamente");
        
    } catch(SQLException e){
        System.out.println("Error al listar los empleados "+ e.getMessage());
    }


        return employees;
    }

    public Employee findEmployeeById(Integer id){

        var employees = new Employee();

        var url = "jdbc:postgresql://localhost:5432/RH";
        var user = "postgres";
        var password = "admin123";

        try(
            
        Connection conn = DriverManager.getConnection(url,user,password);
        var stmnt = conn.prepareStatement("select * from Employees where id = ?");
        var rset =stmnt.executeQuery();

        ){

            stmnt.setInt(1, id);
            stmnt.execute();

            while(rset.next()){
                var employee = new Employee();

                employee.setEmployeeId(rset.getInt("employee_id"));
                employee.setFirstName(rset.getString("first_name"));
                employee.setLastName(rset.getString("last_name"));
                employee.setEmail(rset.getString("email"));
                employee.setPhoneNumber(rset.getString("phone_number"));
                employee.setHireDate(rset.getDate("hire_date").toLocalDate());
                employee.setJobId(rset.getInt("job_id"));
                employee.setSalary(rset.getInt("salary"));
                employee.setManagerId(rset.getInt("manager_id"));
                employee.setDepartmentId(rset.getInt("department_id"));


            }

        System.out.println("Empleados listados correctamente");
        
    } catch(SQLException e){
        System.out.println("Error al listar los empleados "+ e.getMessage());
    }


        
        return employees;
    }
}
