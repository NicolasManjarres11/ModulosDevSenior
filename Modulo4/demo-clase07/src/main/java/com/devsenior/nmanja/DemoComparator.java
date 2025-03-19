package com.devsenior.nmanja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoComparator {

        private class Estudiante{
        private String nombre;
        private int edad;

        public Estudiante(String nombre, int edad) {
            this.edad = edad;
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }



        


    }

    public void run(){

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Nico", 24));
        estudiantes.add(new Estudiante("Dayana", 22));
        estudiantes.add(new Estudiante("Cerati", 2));
        estudiantes.add(new Estudiante("Michell", 9));
        estudiantes.add(new Estudiante("Mirringa", 11));
        estudiantes.add(new Estudiante("Gilma", 59));

        Collections.sort(estudiantes, (e1,e2) -> Integer.compare(e1.getEdad(), e2.getEdad()));

        estudiantes.forEach(e ->  System.out.printf("%s (%d)%n",e.getNombre(),e.getEdad()));

        System.out.println();

        Collections.sort(estudiantes, (e1,e2) -> e1.getNombre().compareTo(e2.getNombre()));

        estudiantes.forEach(e ->  System.out.printf("%s (%d)%n",e.getNombre(),e.getEdad()));

    }
    
}
