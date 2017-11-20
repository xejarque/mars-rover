package com.xejarque.marsrover.navigate.service;

import com.xejarque.marsrover.NavigateHistory.repository.NavigateHistoryRepository;
import com.xejarque.marsrover.commons.EngineStatus;
import com.xejarque.marsrover.commons.MarsRoverStatus;
import com.xejarque.marsrover.location.model.Location;
import com.xejarque.marsrover.location.validator.LocationValidator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class NavigateServiceImpl implements NavigateService {

    private MarsRoverStatus marsRoverStatus;
    private LocationValidator locationValidator;
    private NavigateHistoryRepository navigateHistoryRepository;

    @Autowired
    public NavigateServiceImpl(MarsRoverStatus marsRoverStatus,
                               LocationValidator locationValidator,
                               NavigateHistoryRepository navigateHistoryRepository) {
        this.marsRoverStatus = marsRoverStatus;
        this.locationValidator = locationValidator;
        this.navigateHistoryRepository = navigateHistoryRepository;
    }

    public void move(Location location) {
        locationValidator.validate(location);
        marsRoverStatus.setLocation(location);
        navigateHistoryRepository.save(location);
    }

    @Override
    public void stop() {
        marsRoverStatus.setEngineStatus(EngineStatus.STOPPED);
    }

}
