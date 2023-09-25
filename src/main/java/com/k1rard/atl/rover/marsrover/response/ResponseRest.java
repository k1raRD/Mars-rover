package com.k1rard.atl.rover.marsrover.response;

import com.k1rard.atl.rover.marsrover.models.MarsMap;
import com.k1rard.atl.rover.marsrover.models.Obstacle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseRest {
    private List<Map<String, String>> metadata = new ArrayList<>();

    public List<Map<String, String>> getMetadata() {
        return metadata;
    }

    public void setMetadata(MarsMap marsMap) {
        Map<String, String> map = new HashMap<>();
        Integer numberOfObstacles = marsMap.getElements()
                .stream()
                .filter(a -> a instanceof Obstacle)
                .toList().size();

        map.put("numOfElements", String.valueOf(marsMap.getElements().size()));
        map.put("obstacles", String.valueOf(numberOfObstacles));
        metadata.add(map);
    }
}
