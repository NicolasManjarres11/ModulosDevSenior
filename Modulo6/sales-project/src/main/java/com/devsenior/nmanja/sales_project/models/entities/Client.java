package com.devsenior.nmanja.sales_project.models.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


//Carpeta de las entidades de los modelos

//Lombok crea automáticamente lo que de definamos por medio de las etiquetas

/* @Setter //Genera los métodos Set de cada uno de los atributos
@Getter //Genera los métodos Get de cada uno de los atributos
@NoArgsConstructor //Contructor vacio
@AllArgsConstructor //Constructor con todos los atributos
 */

@Data //Define los métodos básicos o principales de un POJO
@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //JPA generará automáticamente el valor
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String phone;

    @Column(nullable = false)
    private LocalDate hireDate;
    
}
