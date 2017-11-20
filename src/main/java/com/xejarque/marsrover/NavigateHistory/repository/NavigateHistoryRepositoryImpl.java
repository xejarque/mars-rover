package com.xejarque.marsrover.NavigateHistory.repository;

import com.xejarque.marsrover.location.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NavigateHistoryRepositoryImpl implements NavigateHistoryRepository {

    private List<Location> locations = new ArrayList<>();

    public void save(Location location) {
        locations.add(location);
    }

    public List<Location> list() {
        return locations;
    }

    public void clear() {
        locations.clear();
    }
}
