package com.devsenior.nmanja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.devsenior.nmanja.vo.Department;
import com.devsenior.nmanja.vo.Employee;

public class DepartmentDao extends AbstractDao<Department, Integer>{

    @Override
    public void save(Department d) {

        try(

        var conn = getConnection();
        var stmt = conn.createStatement();

        ){

            var query = """
                    INSERT INTO public.departments
                    (department_id, department_name, location_id)
                    VALUES(nextval('departments_department_id_seq'::regclass), '%s', %d);
                    """;
            var sql = String.format(query, 
                d.getDepartmentName(),
                d.getLocationId()
            );

            stmt.execute(sql);
            
            System.out.println("Departamento agregado correctamente");

        }catch(SQLException e){
            System.out.println("Error al guardar departamento: "+ e);
        }

    }

    @Override
    public void update(Integer id, Department d) {
        try(
            var conn = getConnection();
            var stmt = conn.createStatement();
        ){

            var query = """
                    UPDATE public.departments
                    SET department_name='%s', location_id=%d
                    WHERE department_id=%d;
                    """;

            var sql = String.format(query,
                d.getDepartmentName(),
                d.getLocationId(),
                id
            );

            stmt.execute(sql);

            System.out.println("Departamento actualizado correctamente");


        }catch(SQLException e){
            System.out.println("Error al actualizar departamento: "+e);
        }

    }

    @Override
    public void delete(Integer id) {
        try(
            var conn = getConnection();
            var stmt = conn.prepareStatement("DELETE FROM public.departments WHERE department_id= ?;");
        ){

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Departamento eliminado correctamente.");

        } catch(SQLException e){
            System.out.println("Error al eliminar Departamento: "+e);
        }

    }

    @Override
    public List<Department> findAll() {

        var departments = new ArrayList<Department>();

        try(
            var conn = getConnection();
            var stmt = conn.prepareStatement("select * from departments");
            var rst = stmt.executeQuery();
        ) {
            

            while(rst.next()){
            
                var department = new Department();

                department.setDepartmentId(rst.getInt("department_id"));
                department.setDepartmentName(rst.getString("department_name"));
                department.setLocationId(rst.getInt("location_id"));
                
                departments.add(department);
            }

        } catch (Exception e) {
            System.out.println("Error al listar departamentos: "+ e);
        }

        return departments;

    }

    @Override
    public Department findbyId(Integer id) {
    
        Department department = null;

        try(
            var conn = getConnection();
            var stmt = conn.prepareStatement("select * from departments where department_id=?");


        ){

            stmt.setInt(1, id);
            var rset = stmt.executeQuery();
            


            
            if(rset.next()){
                department = new Department();

                department.setDepartmentId(rset.getInt("department_id"));
                department.setDepartmentName(rset.getString("department_name"));
                department.setLocationId(rset.getInt("location_id"));

            } else{
                System.out.println("No se encontró el departamento con ID: "+ id);
            }


        }catch(SQLException e){
            System.out.println("Error al buscar departamento por ID: "+e);
        }
        
        
        
        return department;
    }

    }

