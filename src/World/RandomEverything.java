package World;
import World.Person.Person;
import static World.Country.isInfectedInCountry;
import World.Virus.Virus;
import static World.Virus.Mutation.virusMutation;
import java.util.Random;

public class RandomEverything {
    private static int VaccinePercentageChance=100;
    private static int MutationPercentageChance=1000;
    public static boolean randomVaccineFound(){//szansa na wynalezienie szczepionki
        Random random = new Random();
        VaccinePercentageChance-=5;
        return random.nextInt(VaccinePercentageChance) + 1 == 1;
    }
    public static void randomMutation(World world, Virus virus){
        Random random = new Random();
        MutationPercentageChance-=20;//zwiększa sie szansa na mutacje
        if (random.nextInt(MutationPercentageChance) < world.getInfectedPeople()){
            virusMutation(virus);
            VaccinePercentageChance*=0.5;//zmniejsza sie szansa na szczepionke
        }

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
                (random.nextDouble(virus.getLethality()*20) + 1 <= 1 * dieAgeMultiplier(person))) {
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
                (random.nextDouble(virus.getFactorOfContagious())*0.25 + 1 <= 1 * dieAgeMultiplier(person)) &&
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
            if(person.getTimeSinceInfection()>virus.getTimeOfDisease() ||
                    (random.nextDouble(virus.getLethality()*10)) + 1 <= 1 * dieAgeMultiplier(person)){
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

}
