package com.xejarque.marsrover.message.repository;

import com.xejarque.marsrover.commons.Message;

import java.util.List;

public interface MessageRepository {

    void saveMessage(Message message);
    List<Message> listMessages();
}
