package com.devsenior.nmanja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.devsenior.nmanja.dao.EmployeeDao;
import com.devsenior.nmanja.vo.Employee;

public class Main {

    public static void main(String[] args) {

        var employee = new Employee();
        

/*         employee.setFirstName("Nicolas");
        employee.setLastName("Manjarres");
        employee.setEmail("nico@gmail");
        employee.setPhoneNumber("123456789");
        employee.setDepartmentId(1);
        employee.setManagerId(100);
        employee.setSalary(15000);
        employee.setJobId(1);
        employee.setHireDate(LocalDate.now()); */

        var employeeDao = new EmployeeDao();

        //update

/*         employee.setEmail("nicolasmanjarresg@gmail.com");
        employee.setPhoneNumber("3192842215");
        employee.setSalary(50000);
        employeeDao.updateEmployee(2, employee); */

        //delete

        /* employeeDao.deleteEmployee(2); */

        /* employeeDao.findAllEmployees().forEach(System.out::println); */

        var empleado = employeeDao.findEmployeeById(193);
        System.out.println(empleado);


        
        
    }

    public static void testConnection()  {
        //Driver manager - Conexión a la base de datos

/*         var ids = new ArrayList<Integer>();
        var names = new ArrayList<String>();
        var emails = new ArrayList<String>();
        var salaries = new ArrayList<Integer>(); */

        var employees = new ArrayList<Employee>();

        var url = "jdbc:postgresql://localhost:5432/RH";
        var user = "postgres";
        var password = "admin123";

                

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");


            //Preparar una sentencia para lanzar una instrucción SQL a la BD

            Statement stmnt = conn.createStatement(); //Crear el statement para la base de datos

            //Con ResultSet trae la información que esté solicitando

            ResultSet rset = stmnt.executeQuery("select * FROM EMPLOYEES");

            while(rset.next()){

/*                 var employee = new Employee();
                employee.setId(rset.getInt(1));
                employee.setName(rset.getString(2));
                employee.setEmail(rset.getString(4));
                employee.setSalary(rset.getInt(8));

                employees.add(employee);

                employees.forEach(System.out::println); */

/*                 ids.add(rset.getInt(1));
                names.add(rset.getString(2));
                emails.add(rset.getString(4));
                salaries.add(rset.getInt(8)); */



/*                 var id = rset.getInt(1);
                var name = rset.getString(2);
                var email = rset.getString(4);
                var salary = rset.getInt(8); */
                /* System.out.printf("El empleado con id %d se llama '%s' con email '%s' y gana $ %,d%n",id,name,email,salary); */

            }

            //Cerrar conexiones o flujos (Enviar o traer datos son flujos)

            rset.close();
            stmnt.close();
            conn.close();

/*             for (int i = 0; i < ids.size(); i++) {
                System.out.printf("El empleado con id %d se llama %s con email %s y gana $ %,d%n",
                ids.get(i),names.get(i),emails.get(i),salaries.get(i));

            } */


        } catch (SQLException e) {
            System.out.println("Error al intentar conectar a la base de datos");
        }


        

    }
}
