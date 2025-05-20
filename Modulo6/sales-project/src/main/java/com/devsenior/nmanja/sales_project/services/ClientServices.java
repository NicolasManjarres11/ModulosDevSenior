package com.devsenior.nmanja.sales_project.services;

import java.util.List;

import org.springframework.aop.target.LazyInitTargetSource;

import com.devsenior.nmanja.sales_project.models.entities.Client;

public interface ClientServices {

    List<Client> getClients();
    Client saveClient(Client client);
    
}
