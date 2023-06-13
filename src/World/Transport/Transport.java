package World.Transport;

import World.Country;
import World.Person.Person;
import World.World;

import static World.AnotherDay.RandomEverything.randomTransport;

public class Transport {
    int timeOfTravel;
    final boolean isIntercontinental;
    final boolean isInternational;
    final String accessibility;
    final Country destination;

    public Transport(int timeOfTravel, boolean isIfIntercontinental, boolean isIfInternational, String accessibility, Country destination) {
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

    public static void transport(Person person, World world) {
        if (person.isAlive()) {
            if (person.isInTransport()) {
                person.setDaysSinceTransport(person.getDaysSinceTransport() + 1);

                if (person.getNumberOfTransport() < world.getTransports().size() &&
                        world.getTransports().get(person.getNumberOfTransport()).getTimeOfTravel() <= person.getDaysSinceTransport()) {
                    person.setInTransport(false);

                    if (person.isInfected()) {
                        person.getCountry().endOfTheTransportAndPersonIsSick();
                    }
                }

            } else {
                Transport newTransport = randomTransport(person, World.getRandomCountry(world));
                if (newTransport != null) {
                    newTransport.setTimeOfTravel(newTransport.getTimeOfTravel() + world.getDayCounter());
                    world.getTransports().add(newTransport);
                    person.setInTransport(true);
                    person.setNumberOfTransport(world.getTransports().size());

                    person.getCountry().someoneLeftTheCountry(person);

                    person.setCountry(newTransport.destination);
                    person.getCountry().newHumanInTheCountry();

                    person.setDaysSinceTransport(0);

                    if (person.isInfected()) {
                        person.getCountry().someoneIsSickInTransport();
                    }
                }
            }
        }
    }

}
