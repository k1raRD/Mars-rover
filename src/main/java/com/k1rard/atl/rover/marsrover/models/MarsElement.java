package com.k1rard.atl.rover.marsrover.models;

import lombok.Getter;

import java.util.Objects;

public abstract class MarsElement {
    private String name;
    private Integer positionX = 0;
    private Integer positionY = 0;
    private Integer facing;

    public void setPosition(Integer x, Integer y, Integer facing) {
        this.positionX = x;
        this.positionY = y;
        this.facing = facing;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public String getPositions() {
        return this.positionY + ", " + this.positionX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFacing() {
        return facing;
    }

    public void setFacing(Integer facing) {
        this.facing = facing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsElement that = (MarsElement) o;
        return Objects.equals(positionX, that.positionX) && Objects.equals(positionY, that.positionY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY);
    }
}
