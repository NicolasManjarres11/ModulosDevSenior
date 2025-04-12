package com.devsenior.nmanja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.devsenior.nmanja.vo.Employee;

public class EmployeesDao extends AbstractDao<Employee, Integer>{

    @Override
    public void save(Employee emp) {

        try(
            var conn = getConnection();
            var stmt = conn.createStatement();
        ){

            var query = """
                
                INSERT INTO public.employees
                        (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id)
                        VALUES(nextval('employees_employee_id_seq'::regclass), '%s', '%s', '%s', '%s', '%s', %d, %d, %d, %d);

                """;
            
            var sql = String.format(query, 
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmail(),
                        emp.getPhonenumber(),
                        emp.getHireDate(),
                        emp.getJobId(),
                        emp.getSalary(),
                        emp.getManagerId(),
                        emp.getDepartmentId());

            System.out.println(sql);
            
            stmt.execute(sql);

            System.out.println("Empleado guaradado correctamente");

        } catch(SQLException e){
            System.out.println("Error al guardar el empleado. "+ e);

        }

        

        
    }

    @Override
    public void update(Integer id, Employee emp) {
        
        try(
            var conn = getConnection();
            var pstmt = conn.prepareStatement("""
                UPDATE public.employees
                SET first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, salary = ?, manager_id = ?, department_id = ?
                WHERE employee_id = ?
            """);
        ){

            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhonenumber());
            pstmt.setDate(5, java.sql.Date.valueOf(emp.getHireDate())); // asegúrate del tipo
            pstmt.setInt(6, emp.getJobId());
            pstmt.setInt(7, emp.getSalary());
            pstmt.setInt(8, emp.getManagerId());
            pstmt.setInt(9, emp.getDepartmentId());
            pstmt.setInt(10, id);
        
            pstmt.executeUpdate();
        
            System.out.println("Empleado actualizado correctamente");


        }catch(SQLException e){
            System.out.println("Error al actualizar empleado: "+e);
        }

    }

    @Override
    public void delete(Integer id) {

        try(
            var conn = getConnection();
            var stmt = conn.prepareStatement("DELETE FROM public.employees WHERE employee_id= ?;");
        ){

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Empleado eliminado correctamente.");

        } catch(SQLException e){
            System.out.println("Error al eliminar empleado: "+e);
        }


    }

    @Override
    public List<Employee> findAll() {

        var employees = new ArrayList<Employee>();

        try(
            
            var conn = getConnection();
            var stmt = conn.prepareStatement("select * from employees");
            var rset = stmt.executeQuery();
        ) {
            
            
            while(rset.next()){

                var employee = new Employee();

                employee.setEmployeeId(rset.getInt("employee_id"));
                employee.setFirstName(rset.getString("first_name"));
                employee.setLastName(rset.getString("last_name"));
                employee.setEmail(rset.getString("email"));
                employee.setPhonenumber(rset.getString("phone_number"));
                employee.setHireDate(rset.getDate("hire_date").toString());
                employee.setJobId(rset.getInt("job_id"));
                employee.setSalary(rset.getInt("salary"));
                employee.setManagerId(rset.getInt("manager_id"));
                employee.setDepartmentId(rset.getInt("department_id"));

                employees.add(employee);
            }

            
        } catch (SQLException e) {
            System.out.println("Error al listar empleados: "+e);
        }

        return employees;
    }

    @Override
    public Employee findbyId(Integer id) {
        
        Employee employee = null;

        try(
            var conn = getConnection();
            var stmt = conn.prepareStatement("select * from employees where employee_id=?");


        ){

            stmt.setInt(1, id);
            var rset = stmt.executeQuery();
            


            
            if(rset.next()){
                employee = new Employee();
                employee.setEmployeeId(rset.getInt("employee_id"));
                employee.setFirstName(rset.getString("first_name"));
                employee.setLastName(rset.getString("last_name"));
                employee.setEmail(rset.getString("email"));
                employee.setPhonenumber(rset.getString("phone_number"));
                employee.setHireDate(rset.getDate("hire_date").toString());
                employee.setJobId(rset.getInt("job_id"));
                employee.setSalary(rset.getInt("salary"));
                employee.setManagerId(rset.getInt("manager_id"));
                employee.setDepartmentId(rset.getInt("department_id"));

            } else{
                System.out.println("No se encontró el empleado con ID: "+ id);
            }


        }catch(SQLException e){
            System.out.println("Error al buscar empleado por ID: "+e);
        }
        
        
        
        return employee;
    }





}
