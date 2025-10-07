package com.devsenior.nmanja.messaging_app.model.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Message {

    @Id
    private String id;

    private String senderId;

    private String receiverId;

    private String content;

    private LocalDateTime timestamp;

    private Type type;

    private Status status;

    public static enum Type {
        TEXT("text"),
        IMAGE("image"),
        LINK("link");

        private String value;

        Type(String value){
            this.value=value;
        }

        public String toString(){
            return value;
        }

        public static Type fromString(String value){
            return switch(value){
                case "text" -> TEXT;
                case "image" -> IMAGE;
                case "link" -> LINK;
                default -> TEXT;
            };
        }


    }

    public static enum Status{
        SEND, READ;
    }
    
}
