package com.devsenior.nmanja.sales_project.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.sales_project.models.entities.Client;
import com.devsenior.nmanja.sales_project.services.ClientServices;

import lombok.RequiredArgsConstructor;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor //Crea un constructor con los parámetros requeridos
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    
    private final ClientServices clientServices;


    @GetMapping
    public List<Client> getAllClients() {
        return clientServices.getClients();
    }
    
    @PostMapping
    public Client newClient(@RequestBody Client client) {
        //TODO: process POST request
        
        return clientServices.saveClient(client);
    }
    
    
}
