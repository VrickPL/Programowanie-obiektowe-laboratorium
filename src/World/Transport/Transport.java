package Transport;

public abstract class Transport {
    final int amountOfPeople;
    final int timeOfTravel;
    final boolean isIntercontinental;
    final boolean isInternational;
    final String accessibility;

    public Transport(int amountOfPeople, int timeOfTravel, boolean isIfIntercontinental, boolean isIfInternational, String accessibility) {
        this.amountOfPeople = amountOfPeople;
        this.timeOfTravel = timeOfTravel;
        this.isIntercontinental = isIfIntercontinental;
        this.isInternational = isIfInternational;
        this.accessibility = accessibility;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public int getTimeOfTravel() {
        return timeOfTravel;
    }

    public boolean isIntercontinental() {
        return isIntercontinental;
    }

    public boolean isInternational() {
        return isInternational;
    }
}
