package com.devsenior.nmanja;

import com.devsenior.nmanja.dao.EmployeeDao;

public class Main {
    public static void main(String[] args) {
        
        var dao = new EmployeeDao();
        
        dao.findAll().forEach(System.out::println);
    }
}