package com.devsenior.nmanja;


import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoClients;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        
        var uri = "mongodb://localhost:27017";

        try(var client = MongoClients.create(uri)) {
            
            log.info("Conectado");

            var database = client.getDatabase("Prueba");
            var collection = database.getCollection("Estudiantes");

            var document = new Document();

            document.append("name", "Nicolas Manjarres")
                    .append("lenguaje", "Java");

            var result = collection.insertOne(document);

            log.info("Se ha creado un documento con el id {}", result.getInsertedId());

        } catch (Exception e) {
            log.error("Error al conectar a la base de datos");
        }

    }
}