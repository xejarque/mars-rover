package com.xejarque.marsrover.NavigateHistory.controller;

import com.xejarque.marsrover.NavigateHistory.message.NavigateHistoryMessage;
import com.xejarque.marsrover.NavigateHistory.service.NavigateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class NavigateHistoryController {

    private static final String LOCATION_URL = "/marsRover/navigateHistory";

    private NavigateHistoryService navigateHistoryService;

    @Autowired
    public NavigateHistoryController(NavigateHistoryService navigateHistoryService) {
        this.navigateHistoryService = navigateHistoryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = LOCATION_URL)
    public NavigateHistoryMessage list() {
        return new NavigateHistoryMessage(navigateHistoryService.list(), "The requested list.");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = LOCATION_URL)
    public NavigateHistoryMessage clear() {
        navigateHistoryService.clear();
        return new NavigateHistoryMessage(new ArrayList<>(), "History cleaned");
    }


}
