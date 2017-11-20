package com.xejarque.marsrover.location.validator;

import com.xejarque.marsrover.location.model.Location;
import org.junit.Test;

import javax.validation.ValidationException;


public class LocationValidatorTest {

    @Test(expected = ValidationException.class)
    public void should_throw_an_exception_when_a_invalid_location_is_given() {
        Location location = new Location(40839298374620f, 20f);
        new LocationValidator().validate(location);
    }

    @Test
    public void should_not_throw_an_exception_when_a_valid_location_is_given() {
        Location location = new Location(43f, 20f);
        new LocationValidator().validate(location);
    }

}
