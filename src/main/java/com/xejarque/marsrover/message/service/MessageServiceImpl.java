package com.xejarque.marsrover.message.service;

import com.xejarque.marsrover.commons.EngineStatus;
import com.xejarque.marsrover.commons.MarsRoverStatus;
import com.xejarque.marsrover.commons.Message;
import com.xejarque.marsrover.location.model.Location;
import com.xejarque.marsrover.location.validator.LocationValidator;
import com.xejarque.marsrover.message.repository.MessageRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public void sendMessage(Message message) {
        messageRepository.saveMessage(message);
    }

    @Override
    public List<Message> listMessages() {
        return messageRepository.listMessages();
    }
}
