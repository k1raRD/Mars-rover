package com.k1rard.atl.rover.marsrover.enums;

public enum Directions {
    NORTH(1), EAST(2), SOUTH(3), WEST(4);

    private Integer val;

    Directions(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
