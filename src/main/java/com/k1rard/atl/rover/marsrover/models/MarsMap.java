package com.k1rard.atl.rover.marsrover.models;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class MarsMap {

    private Set<MarsElement> elements;


    public MarsMap() {
        this.elements = new HashSet<>();
    }

    public boolean addElement(MarsElement element) {
        return elements.add(element);
    }
    public boolean isValidPosition(MarsElement element) {
        return elements.contains(element);
    }

    public Rover getRover() {
        return (Rover) elements.stream()
                .filter(a -> a instanceof Rover)
                .findFirst().orElseGet(null);
    }
}
