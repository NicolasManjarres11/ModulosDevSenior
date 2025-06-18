package com.devsenior.nmanja.user_register_demo.exception;

public class UserAlreadyExitsException extends RuntimeException{

    public UserAlreadyExitsException(){
        super("El usuario ya existe en el sistema");
    }
    
}
