package com.devsenior.nmanja.messaging_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.messaging_app.model.dto.MessageRequest;
import com.devsenior.nmanja.messaging_app.model.dto.MessageResponse;
import com.devsenior.nmanja.messaging_app.service.MessageService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/messages")

public class MessageController {

    private final MessageService messageService;


    @GetMapping("/{receiver}/{sender}")
    public List<MessageResponse> getMessagesFromSender(@PathVariable String receiver, @PathVariable String sender) {
        return messageService.getMessage(receiver, sender);
    }

    @PostMapping
    public void sendMessage(@RequestBody MessageRequest request) {        
        messageService.sendMessage(request);
    }
    
    
    
}
