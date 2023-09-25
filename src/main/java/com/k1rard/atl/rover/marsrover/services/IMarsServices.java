package com.k1rard.atl.rover.marsrover.services;

import com.k1rard.atl.rover.marsrover.models.MarsMap;
import com.k1rard.atl.rover.marsrover.response.MarsMapResponseRest;
import org.springframework.http.ResponseEntity;

public interface IMarsServices {


    ResponseEntity<MarsMapResponseRest> giveInstructions(String commands);

    MarsMapResponseRest getInfo();

    ResponseEntity<?> getActualInfo();
}
