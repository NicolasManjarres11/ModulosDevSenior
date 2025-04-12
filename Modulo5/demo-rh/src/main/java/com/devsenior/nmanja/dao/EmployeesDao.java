package com.devsenior.nmanja.dao;

import java.sql.SQLException;

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
            var stmt = conn.createStatement();
        ){

            var query = """
                    UPDATE public.employees
                    SET first_name='%s', last_name='%s', email='%s', phone_number='%s', hire_date='%s', job_id=%d, salary=%d, manager_id=%d, department_id=%d
                    WHERE employee_id= %d;
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
                emp.getDepartmentId(),
                id
            );

            stmt.execute(sql);

            System.out.println("Empleado actualizado correctamente");


        }catch(SQLException e){
            System.out.println("Error al actualizar empleado: "+e);
        }

    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void findbyId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findbyId'");
    }



}
