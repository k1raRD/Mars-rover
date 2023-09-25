package com.k1rard.atl.rover.marsrover.services;

import com.k1rard.atl.rover.marsrover.enums.Directions;
import com.k1rard.atl.rover.marsrover.models.MarsMap;
import com.k1rard.atl.rover.marsrover.models.Obstacle;
import com.k1rard.atl.rover.marsrover.models.Rover;
import com.k1rard.atl.rover.marsrover.response.MarsMapResponse;
import com.k1rard.atl.rover.marsrover.response.MarsMapResponseRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MarsServicesImpl implements IMarsServices{

    private MarsMap marsMap;
    private MarsMapResponseRest marsMapResponseRest;

    @Override
    public ResponseEntity<MarsMapResponseRest> giveInstructions(String commands) {
        try {
            Rover rover = marsMap.getRover();
            rover.process(commands);
            marsMapResponseRest = getInfo();
        } catch (Exception e) {
            return new ResponseEntity<>(marsMapResponseRest, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(marsMapResponseRest, HttpStatus.NO_CONTENT);
    }

    @Override
    public MarsMapResponseRest getInfo() {
        if(marsMap == null) {
            marsMap = defaultInfo();
        }
        MarsMapResponse marsMapResponse = new MarsMapResponse();
        marsMapResponse.setElements(marsMap.getElements());
        marsMapResponse.setRover(marsMap.getRover());
        marsMapResponseRest = new MarsMapResponseRest();
        marsMapResponseRest.setMarsMapResponse(marsMapResponse);
        marsMapResponseRest.setMetadata(marsMap);
        return marsMapResponseRest;
    }

    @Override
    public ResponseEntity<?> getActualInfo() {
         return new ResponseEntity<>(getInfo(), HttpStatus.OK);
    }

    private MarsMap defaultInfo() {
        Rover rover = new Rover();
        rover.setPosition(0, 0, Directions.NORTH.getVal());
        Obstacle obstacle1 = new Obstacle();
        obstacle1.setName("Stone");
        obstacle1.setPosition(3, 3, Directions.WEST.getVal());
        Obstacle obstacle2 = new Obstacle();
        obstacle2.setName("Big stone");
        obstacle2.setPosition(5, 9, Directions.WEST.getVal());
        Obstacle obstacle3 = new Obstacle();
        obstacle3.setName("Stone");
        obstacle3.setPosition(21, 5, Directions.WEST.getVal());
        Obstacle obstacle4 = new Obstacle();
        obstacle4.setName("Ship");
        obstacle4.setPosition(12, 32, Directions.WEST.getVal());
        marsMap = new MarsMap();
        marsMap.addElement(rover);
        marsMap.addElement(obstacle1);
        marsMap.addElement(obstacle2);
        marsMap.addElement(obstacle3);
        marsMap.addElement(obstacle4);
        return marsMap;
    }
}
