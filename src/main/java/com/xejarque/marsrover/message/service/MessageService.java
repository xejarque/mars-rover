package com.xejarque.marsrover.message.service;

import com.xejarque.marsrover.commons.Message;
import com.xejarque.marsrover.location.model.Location;

import java.util.List;

public interface MessageService {

    void sendMessage(Message message);
    List<Message> listMessages();

}
