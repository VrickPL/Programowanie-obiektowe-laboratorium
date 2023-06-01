package World.Transport;

import World.Country;

public class Car extends Transport {
    public Car(int timeOfTravel, Country destination) {
        super( timeOfTravel, false,true, "high", destination);
    }
}
