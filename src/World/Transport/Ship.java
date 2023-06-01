package World.Transport;

import World.Country;

public class Ship extends Transport {
    public Ship(int timeOfTravel, Country destination) {
        super(timeOfTravel,true,false,"low",destination);
    }
}
