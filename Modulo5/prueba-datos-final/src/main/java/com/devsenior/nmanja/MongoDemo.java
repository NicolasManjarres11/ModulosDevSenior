package com.devsenior.nmanja;

import org.bson.Document;

import com.mongodb.client.MongoClients;

public class MongoDemo {

    public void dataTest(){
        try (var client = MongoClients.create("mongodb://localhost:27017")) {
            var db = client.getDatabase("RH");
            var col = db.getCollection("departments");

            var doc = new Document();
            var loc = new Document().append("address","Cra 9 # 57")
                            .append("city", "bogota");


            doc.append("name", "Sistemas")
                .append("location", loc);
            

            col.insertOne(doc);

            col.insertOne(new Document()
            .append("name", "Mesa de ayuda")
            .append("location",new Document()
                .append("city", "suba")
                .append("address", "lejosss")));

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
