package com.k1rard.atl.rover.marsrover.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarsMapResponseRest extends ResponseRest{
    private MarsMapResponse marsMapResponse = new MarsMapResponse();
}
