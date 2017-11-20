package com.xejarque.marsrover.navigate.service;

import com.xejarque.marsrover.location.model.Location;

public interface NavigateService {

    void move(Location location);
    void stop();

}
