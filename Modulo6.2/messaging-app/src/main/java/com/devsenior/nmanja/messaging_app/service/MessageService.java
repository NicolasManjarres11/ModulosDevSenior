package com.devsenior.nmanja.messaging_app.service;

import java.util.List;

import com.devsenior.nmanja.messaging_app.model.dto.MessageRequest;
import com.devsenior.nmanja.messaging_app.model.dto.MessageResponse;

public interface MessageService {

    List<MessageResponse> getMessage(String receiver, String sender);
    void sendMessage(MessageRequest message);
    
}
