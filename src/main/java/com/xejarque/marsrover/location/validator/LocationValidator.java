package com.xejarque.marsrover.location.validator;

import com.xejarque.marsrover.location.model.Location;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;

@Component
public class LocationValidator {

    public void validate(Location location) {

        if (location == null) {
            throw new ValidationException("location is null.");
        }

        if (location.getLatitude() > 300) {
            throw new ValidationException("max latitude is 300.");
        }

        if (location.getLongitude() > 300) {
            throw new ValidationException("max longitude is 300.");
        }

    }
}
