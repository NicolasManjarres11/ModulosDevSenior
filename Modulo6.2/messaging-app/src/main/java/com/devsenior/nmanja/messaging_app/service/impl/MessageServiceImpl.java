package com.devsenior.nmanja.messaging_app.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.nmanja.messaging_app.model.document.Message;
import com.devsenior.nmanja.messaging_app.model.dto.MessageRequest;
import com.devsenior.nmanja.messaging_app.model.dto.MessageResponse;
import com.devsenior.nmanja.messaging_app.repository.MessageRepository;
import com.devsenior.nmanja.messaging_app.service.MessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class MessageServiceImpl implements MessageService{
    
    private final MessageRepository messageRepository;
    private final DateTimeFormatter dateTimeFormatter;
    
    
    @Override
    public List<MessageResponse> getMessage(String receiverId, String senderId) {

        return messageRepository.findAllBetweenReceiverAndSender(receiverId, senderId).stream()
        .map(m -> {
            var response = new MessageResponse();
            response.setType(m.getType().toString());
            response.setContent(m.getContent());
            response.setStatus(m.getStatus().toString());
            response.setTimestamp(dateTimeFormatter.format(m.getTimestamp()));
            return response;
        })
        .toList();
        
        // TODO Auto-generated method stub
/*         return messageRepository.findAllByReceiverIdAndSenderIdOrderByTimestamp(receiverId, senderId).stream()
            .map(m -> {
            var response = new MessageResponse();
            response.setType(m.getType().toString());
            response.setContent(m.getContent());
            response.setStatus(m.getStatus().toString());
            response.setTimestamp(dateTimeFormatter.format(m.getTimestamp()));
            return response;
        })
        .toList(); */

            
    }

    @Override
    public void sendMessage(MessageRequest message) {
        // TODO Auto-generated method stub

        var document = new Message();

        document.setSenderId(message.getSenderId());
        document.setReceiverId(message.getReceiverId());
        document.setContent(message.getContent());
        document.setTimestamp(LocalDateTime.now());
        document.setType(Message.Type.fromString(message.getType()));
        document.setStatus(Message.Status.SEND);
        

        document = messageRepository.save(document);
        
    }

    
    
}
