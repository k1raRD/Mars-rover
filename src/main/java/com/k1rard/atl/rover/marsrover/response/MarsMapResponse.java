package com.k1rard.atl.rover.marsrover.response;

import com.k1rard.atl.rover.marsrover.models.MarsElement;
import com.k1rard.atl.rover.marsrover.models.Rover;
import lombok.Data;

import java.util.Set;

@Data
public class MarsMapResponse {
    private Set<MarsElement> elements;
    private Rover rover;
}
