package com.devsenior.nmanja;

public class InvalidOptionException extends RuntimeException{

    public InvalidOptionException(){
        this("La opcion seleccionada es invalida");
    }

    public InvalidOptionException(String message){
        super(message);

    }

}
