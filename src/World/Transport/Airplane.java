package World.Transport;

import World.Country;

public class Airplane extends Transport{
    public Airplane(int timeOfTravel, Country destination) {
        super( timeOfTravel, true, true, "medium", destination);
    }
}
