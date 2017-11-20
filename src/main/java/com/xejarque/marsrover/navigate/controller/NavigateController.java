package com.xejarque.marsrover.navigate.controller;

import com.xejarque.marsrover.navigate.message.NavigateMessage;
import com.xejarque.marsrover.location.model.Location;
import com.xejarque.marsrover.navigate.service.NavigateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NavigateController {

    private static final String LOCATION_URL = "/marsRover/navigate";

    private NavigateService navigateService;

    @Autowired
    public NavigateController(NavigateService navigateService) {
        this.navigateService = navigateService;
    }

    @RequestMapping(method = RequestMethod.PUT, value = LOCATION_URL)
    public NavigateMessage move(@RequestBody Location location) {
        navigateService.move(location);
        return new NavigateMessage("Mars rover is going to: " + location);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = LOCATION_URL)
    public NavigateMessage stop() {
        navigateService.stop();
        return new NavigateMessage("Mars rover is stopped.");
    }






}
