package com.devsenior.nmanja.service_layer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devsenior.nmanja.service_layer.service.LibraryService;

//Inicializat el servicio


//@Configuration //Etiqueta de configuración
public class BeanConfiguration {


    //@Bean
    public LibraryService libraryService(){
        return new LibraryService();
    }

}
