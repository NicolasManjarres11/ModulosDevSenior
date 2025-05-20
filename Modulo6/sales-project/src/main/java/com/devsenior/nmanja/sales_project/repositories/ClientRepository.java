package com.devsenior.nmanja.sales_project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;  //<Tipo modelo, tipo llave primaria>
import org.springframework.stereotype.Repository;

import com.devsenior.nmanja.sales_project.models.entities.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

    //Aquí definimos la conexión con la base de datos y nos ayudamos con las funcionalidades de JpaRepository extendiendo la interfaz de dicho repositorio

}
