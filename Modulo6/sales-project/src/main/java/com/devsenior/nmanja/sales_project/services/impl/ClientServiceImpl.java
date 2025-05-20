package com.devsenior.nmanja.sales_project.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.sales_project.models.entities.Client;
import com.devsenior.nmanja.sales_project.repositories.ClientRepository;
import com.devsenior.nmanja.sales_project.services.ClientServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientServices{

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        // TODO Auto-generated method stub
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        // TODO Auto-generated method stub
        return clientRepository.save(client);
    }
    
}
