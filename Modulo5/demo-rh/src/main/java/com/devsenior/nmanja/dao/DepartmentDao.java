package com.devsenior.nmanja.dao;

import java.sql.SQLException;

import com.devsenior.nmanja.vo.Department;

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
