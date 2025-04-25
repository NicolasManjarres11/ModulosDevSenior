package com.devsenior.nmanja;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo {

    public void dataTest(){



        try(var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RH","postgres","admin123");
            var stmt = conn.prepareStatement("select * from employees"); 
            var rset = stmt.executeQuery();
        ){


            while(rset.next()){
                System.out.printf("Empleado %s %S tiene el id %d seencuentra en el departamento %d%n",
                rset.getString("first_name"),
                rset.getString("last_name"),
                rset.getInt("employee_id"),
                rset.getInt("department_id"))
                ;   
            }


            try(var stmt1 = conn.prepareStatement("insert into departments (department_name, location_id) values(?,?)")){
                stmt1.setString(1, "Mantenimiento");
                stmt1.setInt(2, 1500);
                stmt1.executeUpdate();
            }

        }catch(SQLException e){
            System.out.println("Error al conectar con la base de datos. "+ e.getMessage());
        }


    }

}
