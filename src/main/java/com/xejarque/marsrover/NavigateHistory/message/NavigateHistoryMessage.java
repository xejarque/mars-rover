package com.xejarque.marsrover.NavigateHistory.message;

import com.xejarque.marsrover.commons.Message;
import com.xejarque.marsrover.location.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NavigateHistoryMessage implements Message {

    private List<Location> locations;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
