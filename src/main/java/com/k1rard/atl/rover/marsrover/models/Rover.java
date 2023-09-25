package com.k1rard.atl.rover.marsrover.models;

import com.k1rard.atl.rover.marsrover.enums.Directions;
import lombok.NoArgsConstructor;

public class Rover extends MarsElement{
    private String direction;

    public Rover() {
        this.setName("Rover") ;
        this.setFacing(Directions.NORTH.getVal());
        this.direction = Directions.NORTH.toString();
    }

    public void printPosition() {
         direction = Directions.NORTH.toString();
        if (this.getFacing().equals(Directions.NORTH.getVal()) ) {
            direction = Directions.NORTH.toString();
        } else if (this.getFacing().equals(Directions.EAST.getVal())) {
            direction = Directions.EAST.toString();
        } else if (this.getFacing().equals(Directions.WEST.getVal())) {
            direction = Directions.SOUTH.toString();;
        } else if (this.getFacing().equals(Directions.SOUTH.getVal())) {
            direction = Directions.WEST.toString();;
        }
    }

    public void process(String commands) {
        for (int index = 0; index < commands.length(); index++) {
            process(commands.charAt(index));
        }
    }

    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "Give me a correct instructions please!");
        }
    }

    private void move() {
        if (this.getFacing() == Directions.NORTH.getVal()) {
            this.setPositionY(this.getPositionY() + 1);
        } else if (this.getFacing() == Directions.EAST.getVal()) {
            this.setPositionX(this.getPositionX() + 1);
        } else if (this.getFacing() == Directions.SOUTH.getVal()) {
            this.setPositionY(this.getPositionY() - 1);
        } else if (this.getFacing() == Directions.WEST.getVal()) {
            this.setPositionX(this.getPositionX() - 1);
        }
    }

    private void turnLeft() {
        this.setFacing((this.getFacing() - 1) < Directions.NORTH.getVal() ? Directions.WEST.getVal() : this.getFacing() - 1);
    }

    private void turnRight() {
        this.setFacing((this.getFacing() + 1) > Directions.WEST.getVal() ? Directions.NORTH.getVal() : this.getFacing() + 1);
    }
}