package com.xejarque.marsrover.location.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Location {

    private float latitude;
    private float longitude;

}
