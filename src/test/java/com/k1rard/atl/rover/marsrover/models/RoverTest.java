package com.k1rard.atl.rover.marsrover.models;

import com.k1rard.atl.rover.marsrover.enums.Directions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    Rover rover;

    @Test
    @DisplayName("Default position rover test")
    void defaultPositionTest() {
        rover = new Rover();
        int expectedPosition = 0;
        int directionExpected = Directions.NORTH.getVal();
        assertAll(
                () -> assertNotNull(rover),
                () -> assertEquals(expectedPosition, rover.getPositionX()),
                () -> assertEquals(expectedPosition, rover.getPositionY()),
                () -> assertEquals(directionExpected, rover.getFacing())
        );
    }

    @Test
    void moveOnYAxisTest() {
        rover = new Rover();
        int positionYExpected = 3;
        int positionXExpected = 0;
        int directionExpected = Directions.NORTH.getVal();
        rover.process("MMM");
        assertAll(
                () -> assertEquals(positionXExpected, rover.getPositionX()),
                () -> assertEquals(positionYExpected, rover.getPositionY()),
                () -> assertEquals(directionExpected, rover.getFacing())
        );
    }

    @Test
    void moveOnXAxisTest() {
        rover = new Rover();
        int positionYExpected = 0;
        int positionXExpected = 3;
        int directionExpected = Directions.EAST.getVal();
        rover.process("RMMM");
        assertAll(
                () -> assertEquals(positionXExpected, rover.getPositionX()),
                () -> assertEquals(positionYExpected, rover.getPositionY()),
                () -> assertEquals(directionExpected, rover.getFacing())
        );
    }

    @Test
    void moveOnBotPositionsNorthDirectionTest() {
        rover = new Rover();
        rover.setPosition(1, 2, Directions.NORTH.getVal());
        rover.process("LMLMLMLMM");
        int positionXExpected = 1;
        int positionYExpected = 3;
        int directionExpected = Directions.NORTH.getVal();
        assertAll(
                () -> assertEquals(positionXExpected, rover.getPositionX()),
                () -> assertEquals(positionYExpected, rover.getPositionY()),
                () -> assertEquals(directionExpected, rover.getFacing())
        );
    }

    @Test
    void moveOnBotPositionseEastDirectionTest() {
        rover = new Rover();
        rover.setPosition(3, 3, Directions.EAST.getVal());
        rover.process("MMRMMRMRRM");
        int positionXExpected = 5;
        int positionYExpected = 1;
        int directionExpected = Directions.EAST.getVal();
        assertAll(
                () -> assertEquals(positionXExpected, rover.getPositionX()),
                () -> assertEquals(positionYExpected, rover.getPositionY()),
                () -> assertEquals(directionExpected, rover.getFacing())
        );
    }
}