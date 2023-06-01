package World.Transport;
import  World.Person.Person;
import World.Country;
import World.World;


import java.util.Random;

public class isTransport {

    public static void transport(Person person, World world){
        if(person.isAlive()){
            if(person.isInTransport()){
                person.setDaysSinceTransport(person.getDaysSinceTransport() + 1);

                if(person.getDaysSinceTransport() >= world.getTransports().get(person.getNumberOfTransport()).getTimeOfTravel()){
                    person.setInTransport(false);

                    if(person.isInfected()){
                        person.getCountry().endOfTheTransportAndPersonIsSick();
                    }
                }
                //ZROBIC
                //wiecej osob w transporcie
                //dla kazdego transportu osobny mnoznik osob
                //losowanie ile ludzi sie transportuje dla max np ( (0.5*liczbaOsobWKraju) % mnoznikTransportu )
            } else {
                Transport newTransport = randomTransport(person, World.getRandomCountry(world));
                if(newTransport != null){
                    newTransport.setTimeOfTravel(newTransport.getTimeOfTravel() + world.getDayCounter());
                    world.getTransports().add(newTransport);
                    person.setInTransport(true);
                    person.setNumberOfTransport(world.getTransports().size());

                    person.getCountry().someoneLeftTheCountry(person);

                    person.setCountry(newTransport.destination);
                    person.getCountry().newHumanInTheCountry();

                    person.setDaysSinceTransport(0);

                    if(person.isInfected()){
                        person.getCountry().someoneIsSickInTransport();
                    }
                }
            }
        }
    }


    public static Transport randomTransport(Person person, Country destinationCountry) {
        Random random = new Random();
        int whichTransport = random.nextInt(30);
        int timeOfTravel = 0;
        switch (whichTransport) {
            case 1 -> {

                if (person.getCountry().isAirport()) {
                    timeOfTravel = random.nextInt(2) + 1;     //TIME OF TRAVEL (1,2)
                    return (Transport) new Airplane(timeOfTravel, destinationCountry);
                }
            }
            case 2 -> {
                if (person.getCountry().isHarbor()) {
                    timeOfTravel = random.nextInt(21) + 10;    //TIME OF TRAVEL (10,30)
                    return (Transport) new Ship(timeOfTravel, destinationCountry);
                }
            }
            case 3 -> {
                timeOfTravel = random.nextInt(5) + 2;        //TIME OF TRAVEL (2,6)
                return (Transport) new Car(timeOfTravel, destinationCountry);
            }
            default -> {
                return null;
            }
        }return null;
    }
}
