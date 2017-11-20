package com.xejarque.marsrover.commons;

import com.xejarque.marsrover.location.model.Location;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MarsRoverStatus {

    private EngineStatus engineStatus = EngineStatus.STOPPED;

    private Location location = new Location(0f, 0f);


}
