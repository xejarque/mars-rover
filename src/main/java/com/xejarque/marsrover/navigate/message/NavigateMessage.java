package com.xejarque.marsrover.navigate.message;

import com.xejarque.marsrover.commons.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NavigateMessage implements Message {

    String message;

    @Override
    public String getMessage() {
        return message;
    }
}
