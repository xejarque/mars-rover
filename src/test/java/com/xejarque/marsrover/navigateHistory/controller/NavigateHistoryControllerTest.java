package com.xejarque.marsrover.navigateHistory.controller;

import com.xejarque.marsrover.NavigateHistory.controller.NavigateHistoryController;
import com.xejarque.marsrover.NavigateHistory.service.NavigateHistoryService;
import com.xejarque.marsrover.location.model.Location;
import de.flapdoodle.embed.process.collections.Collections;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NavigateHistoryControllerTest {

    private static final String LOCATION_URL = "/marsRover/navigateHistory";

    private NavigateHistoryController navigateHistoryController;

    private NavigateHistoryService navigateHistoryService;

    @Before
    public void setUp() throws Exception {
        navigateHistoryService = mock(NavigateHistoryService.class);
        navigateHistoryController = new NavigateHistoryController(navigateHistoryService);
    }


    @Test
    public void should_obtain_the_location_list_from_history() {
        when(navigateHistoryService.list()).thenReturn(locationFixtures());
        given().standaloneSetup(navigateHistoryController)
                .contentType("application/json")
                .when().get(LOCATION_URL)
                .then()
                .statusCode(200)
                .body("message", equalTo("The requested list."))
                .body("locations.size()", is(3));
    }

    @Test
    public void should_obtain_empty_list_from_history() {
        when(navigateHistoryService.list()).thenReturn(new ArrayList<>());
        given().standaloneSetup(navigateHistoryController)
                .contentType("application/json")
                .when().delete(LOCATION_URL)
                .then()
                .statusCode(200)
                .body("message", equalTo("History cleaned"))
                .body("locations.size()", is(0));
    }

    private List<Location> locationFixtures() {
        List<Location> locations = new ArrayList<>();
        return Collections.newArrayList(
                new Location(3f, 8f),
                new Location(6f, 2f),
                new Location(16f, 2f)
                );
    }


}
