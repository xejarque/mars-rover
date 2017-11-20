package com.xejarque.marsrover.NavigateHistory.repository;

import com.xejarque.marsrover.location.model.Location;

import java.util.List;

public interface NavigateHistoryRepository {

    void save(Location location);

    List<Location> list();

    void clear();

}
