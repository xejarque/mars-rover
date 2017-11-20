package com.xejarque.marsrover.message.repository;

import com.xejarque.marsrover.commons.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    List<Message> messages = new ArrayList<>();

    @Override
    public void saveMessage(Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> listMessages() {
        return messages;
    }
}
