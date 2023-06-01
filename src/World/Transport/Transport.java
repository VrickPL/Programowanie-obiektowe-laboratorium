package World.Transport;

import World.Country;

public abstract class Transport {
    int timeOfTravel;
    final boolean isIntercontinental;
    final boolean isInternational;
    final String accessibility;
    final Country destination;

    protected Transport(int timeOfTravel, boolean isIfIntercontinental, boolean isIfInternational, String accessibility, Country destination) {

        this.timeOfTravel = timeOfTravel;
        this.isIntercontinental = isIfIntercontinental;
        this.isInternational = isIfInternational;
        this.accessibility = accessibility;
        this.destination = destination;
    }

    public void setTimeOfTravel(int timeOfTravel) {
        this.timeOfTravel = timeOfTravel;
    }

    public int getTimeOfTravel() {
        return timeOfTravel;
    }

    public Country getDestination() {return destination;}

    public boolean isIntercontinental() {
        return isIntercontinental;
    }

    public boolean isInternational() {
        return isInternational;
    }

}
