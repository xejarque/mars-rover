package com.xejarque.marsrover.navigate.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.xejarque.marsrover.location.model.Location;
import com.xejarque.marsrover.navigate.service.NavigateService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

public class NavigateControllerTest {

    private static final String LOCATION_URL = "/marsRover/navigate";

    private NavigateController navigateController;

    private NavigateService navigateService;

    @Before
    public void setUp() throws Exception {
        navigateService = mock(NavigateService.class);
        navigateController = new NavigateController(navigateService);
    }

    @Test
    public void should_move_rover_when_a_new_location_is_given() {
        Location location = new Location(40f, 20f);
        given().standaloneSetup(navigateController)
                .contentType("application/json")
                .body(location)
                .when().put(LOCATION_URL)
                .then()
                .statusCode(200)
                .body("message", equalTo("Mars rover is going to: " + location));
    }

    @Ignore
    @Test(expected = InvalidFormatException.class)
    public void should_trow_an_exception_when_latitude_is_string() {
        given().standaloneSetup(navigateController)
                .contentType("application/json")
                .body(invalidLongitudeFixture())
                .when().put(LOCATION_URL)
                .then()
                .statusCode(400);
    }

    private String invalidLongitudeFixture() {
        return "{\n" +
                "    \"latitude\": 283.99,\n" +
                "    \"longitude\": \"asdf\"\n" +
                "}";

    }

    @Test
    public void should_stop_rover_when_delete_method_is_called() {
        given().standaloneSetup(navigateController)
                .contentType("application/json")
                .when().delete(LOCATION_URL)
                .then()
                .statusCode(200)
                .body("message", equalTo("Mars rover is stopped."));
    }


}
