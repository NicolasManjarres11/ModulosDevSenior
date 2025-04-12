package com.devsenior.nmanja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao<E, ID> {

    public Connection getConnection() throws SQLException{

        var url = "jdbc:postgresql://localhost:5432/RH";
        var user = "postgres";
        var password = "admin123";
        

        return DriverManager.getConnection(url,user,password);
    }

    public abstract void save(E e);

    public abstract void update(ID id, E e);

    public abstract void delete();

    public abstract void findAll();

    public abstract void findbyId();



}
