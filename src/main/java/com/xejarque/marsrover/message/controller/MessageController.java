package com.xejarque.marsrover.message.controller;

import com.xejarque.marsrover.commons.Message;
import com.xejarque.marsrover.location.model.Location;
import com.xejarque.marsrover.message.service.MessageService;
import com.xejarque.marsrover.navigate.message.NavigateMessage;
import com.xejarque.marsrover.navigate.service.NavigateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static final String LOCATION_URL = "/marsRover/message";

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(method = RequestMethod.PUT, value = LOCATION_URL)
    public void send(@RequestBody Message message) {
        messageService.sendMessage(message);
    }








}
