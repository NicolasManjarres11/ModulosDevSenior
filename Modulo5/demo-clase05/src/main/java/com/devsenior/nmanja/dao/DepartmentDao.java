package com.devsenior.nmanja.dao;

import java.sql.SQLException;

import com.devsenior.nmanja.utils.DatabaseUtil;
import com.devsenior.nmanja.vo.Department;



public class DepartmentDao {

    public void createDepartment(Department department){

        try {
            var conn = DatabaseUtil.getConnection();
            var stmnt = conn.prepareStatement("INSERT INTO public.departments VALUES (1,?,?,?);");

            stmnt.setString(1, department.getDepartmentName());
            stmnt.setInt(2, department.getLocationId());
            stmnt.execute();

        } catch (SQLException e) {
        }
    

    }

}
