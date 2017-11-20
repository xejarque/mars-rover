package com.xejarque.marsrover.NavigateHistory.service;

import com.xejarque.marsrover.location.model.Location;

import java.util.List;

public interface NavigateHistoryService {

    List<Location> list();

    void clear();

}
