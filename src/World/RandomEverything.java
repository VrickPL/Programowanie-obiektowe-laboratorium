package World;
import World.Person.Person;
import static World.Country.isInfectedInCountry;

import World.Transport.Transport;
import World.Virus.ContagiousVirusMutation;
import World.Virus.DeadlyVirusMutation;
import World.Virus.Virus;
import java.util.Random;

public class RandomEverything {
    private static int VaccinePercentageChance=100;
    private static int MutationPercentageChance=1000;
    private static int boundOfRandomingTravel = 30;

    public static void setVaccinePercentageChance(int vaccinePercentageChance) {
        VaccinePercentageChance = vaccinePercentageChance;
    }

    public static int getVaccinePercentageChance() {
        return VaccinePercentageChance;
    }

    public static void setBoundOfRandomingTravel(int boundOfRandomingTravel) {
        RandomEverything.boundOfRandomingTravel = boundOfRandomingTravel;
    }

    public static boolean randomVaccineFound(){//szansa na wynalezienie szczepionki
        Random random = new Random();
        VaccinePercentageChance -= 1 ;
        return random.nextInt(VaccinePercentageChance) + 1 == 1;
    }
    public static Virus randomMutation(World world, Virus virus){
        Random random = new Random();
        MutationPercentageChance-=20;//zwiększa sie szansa na mutacje
        if (random.nextInt(MutationPercentageChance) < world.getInfectedPeople()){
            switch(random.nextInt(2)){
                case 0 -> {
                    DeadlyVirusMutation mutation = new DeadlyVirusMutation(1.2,
                            1, 0.9, 0.7);
                    return mutation.virusMutation(virus);

                }
                case 1 -> {
                    ContagiousVirusMutation mutation = new ContagiousVirusMutation(1.3,
                            0.6, 0.3, 0.8);
                    return mutation.virusMutation(virus);
                }
            }
        }
        return virus;
    }
    public static double dieAgeMultiplier(Person person) {
        if (person.getAge() < 18) {
            return 1;
        } else if (person.getAge() < 60) {
            return 2;
        } else {
            return 5;
        }
    }

    public static boolean randomDie(Virus virus, Person person) {
        Random random = new Random();
        if (person.isInfected() && person.isAlive() &&
                (random.nextDouble(virus.lethality()*20) + 1 <= 1 * dieAgeMultiplier(person))) {
            person.setAlive(false);
            if (person.isInTransport()) {
                person.getCountry().diedInTransport();
            } else {
                person.getCountry().someoneDied();
            }
            return true;
        }
        return false;
    }


    public static boolean randomGetInfected(Virus virus, Person person) {
        Random random = new Random();
        if (person.isAlive() && !person.isInfected() &&
                (random.nextDouble(virus.factorOfContagious())*0.25 + 1 <= 1 * dieAgeMultiplier(person)) &&
                !person.isInTransport() && isInfectedInCountry(person)){
            person.getCountry().someoneIsSick();
            person.setInfected(true);
            return true;
        }
        return false;
    }

    public static boolean recover(Virus virus, Person person) {
        Random random = new Random();
        if (person.isAlive() && person.isInfected()){
            if(person.getTimeSinceInfection()>virus.timeOfDisease() ||
                    (random.nextDouble(virus.lethality()*25)) + 1 <= 1 * dieAgeMultiplier(person)){
                if (person.isInTransport()) {
                    person.getCountry().recoveredInTransport();
                } else {
                    person.getCountry().someoneRecover();
                }
                person.setInfected(false);
                return true;
            }
        }
        return false;
    }

    public static Transport randomTransport(Person person, Country destinationCountry) {
        Random random = new Random();
        int whichTransport = random.nextInt(boundOfRandomingTravel);
        int timeOfTravel = 0;
        switch (whichTransport) {
            case 1 -> {

                if (person.getCountry().isAirport()) {
                    timeOfTravel = random.nextInt(2) + 1;     //TIME OF TRAVEL (1,2)
                    return new Transport(timeOfTravel, true, true, "medium", destinationCountry);
                }
            }
            case 2 -> {
                if (person.getCountry().isHarbor()) {
                    timeOfTravel = random.nextInt(21) + 10;    //TIME OF TRAVEL (10,30)
                    return new Transport(timeOfTravel, true,false,"low", destinationCountry);
                }
            }
            case 3 -> {
                timeOfTravel = random.nextInt(5) + 2;        //TIME OF TRAVEL (2,6)
                return new Transport(timeOfTravel, false,true, "high", destinationCountry);
            }
            default -> {
                return null;
            }
        }return null;
    }

}