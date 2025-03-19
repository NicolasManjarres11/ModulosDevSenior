package com.devsenior.nmanja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoComparable {
    
    private class Estudiante implements Comparable<Estudiante>{
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

        @Override
        public int compareTo(Estudiante otro) {
            if(this.edad < otro.getEdad()){
                return -1;
            } else if( this.edad > otro.getEdad()){
                return 1;
            }
            return 0;
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

        Collections.sort(estudiantes);

        estudiantes.forEach(e ->  System.out.printf("%s (%d)%n",e.getNombre(),e.getEdad()));

    }


}
