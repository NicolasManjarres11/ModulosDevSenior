package com.devsenior.nmanja.messaging_app.model.dto;

import lombok.Data;

@Data
public class MessageRequest {
    
    private String senderId;

    private String receiverId;

    private String content;

    private String type;

}
