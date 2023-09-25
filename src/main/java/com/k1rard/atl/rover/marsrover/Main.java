package com.k1rard.atl.rover.marsrover;

import com.k1rard.atl.rover.marsrover.enums.Directions;
import com.k1rard.atl.rover.marsrover.models.Rover;

public class Main {
    public static void main(String[] args) {
        Rover rover = new Rover();
        rover.setPosition(1, 2, Directions.NORTH.getVal());
        rover.process("LMLMLMLMM");
        rover.printPosition(); // prints 1 3 N
        rover.setPosition(3, 3, Directions.EAST.getVal());
        rover.process("MMRMMRMRRM");
        rover.printPosition(); // prints 5 1 E
    }
}
