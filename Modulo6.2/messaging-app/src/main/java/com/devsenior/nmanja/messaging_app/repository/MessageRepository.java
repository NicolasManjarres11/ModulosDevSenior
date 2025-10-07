package com.devsenior.nmanja.messaging_app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.devsenior.nmanja.messaging_app.model.document.Message;

public interface MessageRepository extends MongoRepository<Message, String>{

    List<Message> findAllByReceiverIdAndSenderIdOrderByTimestamp(String receiverId, String senderId);

    @Query("db.message.find({{$or: [ { receiverId: :receiver, senderId: :sender}, { receiverId: :receiver, senderId: :sender}]})")
    List<Message> findAllBetweenReceiverAndSender(String receiverId, String senderId);
    
}
