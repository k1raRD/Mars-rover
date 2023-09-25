package com.k1rard.atl.rover.marsrover.controllers;

import com.k1rard.atl.rover.marsrover.services.IMarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mars/rover")
public class MarsController {
    @Autowired
    private IMarsServices marsServices;

    @GetMapping
    public ResponseEntity<?> getInfo() {
        return marsServices.getActualInfo();
    }

    @PostMapping("/{commands}")
    public ResponseEntity<?> giveInstructionsRover(@PathVariable("commands") String commands) {
        return  marsServices.giveInstructions(commands);
    }
}
