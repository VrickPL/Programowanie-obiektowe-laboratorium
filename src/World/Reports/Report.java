package World.Reports;
import World.Virus.Virus;
import static World.RandomEverything.randomDie;
import World.World;
import World.Person.Person;
import static World.RandomEverything.randomGetInfected;
import static World.RandomEverything.recover;
import static World.RandomEverything.randomMutation;
import static World.RandomEverything.randomVaccineFound;
import java.util.Scanner;

public class Report {
    Scanner scanner = new Scanner(System.in);
    private int deadPeopleDuringThreeMonths = 0;
    private int infectedPeopleDuringThreeMonths = 0;
    private int recoveredPeopleDuringThreeMonths = 0;



    public void newThreeMonths(){
        deadPeopleDuringThreeMonths = 0;
        infectedPeopleDuringThreeMonths = 0;
        recoveredPeopleDuringThreeMonths = 0;
    }
    public boolean simulationContinue(){
        System.out.println(" ");
        System.out.println("Do you want to continue program?");
        System.out.println("Press 'y' (yes) or 'n' (no): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }
    public void randomEverything(Virus virus, Person person) {
        if (randomDie(virus, person)) {
            deadPeopleDuringThreeMonths++;
        }
        if (randomGetInfected(virus, person)) {
            infectedPeopleDuringThreeMonths++;
        }
        if (recover(virus, person)) {
            recoveredPeopleDuringThreeMonths++;
        }
    }

    public Virus duringThreeMonths(World world, int dayCounter, Virus virus){
        world.setThreeMonthsCounter(world.getThreeMonthsCounter()+1);
        world.setVaccineFound(randomVaccineFound());
        virus = randomMutation(world,virus);
        printInfo(world, dayCounter);
        if(world.getThreeMonthsCounter() % 4 == 0 && world.getThreeMonthsCounter() != 0) world.newYear();
        return virus;
    }
    public void printInfo(World world, int dayCounter){
        System.out.println("-".repeat(30));
        System.out.println("Day: " + dayCounter); //dodac date co sie zmienia co 3 miesiace
        System.out.println("ALIVE - " + world.getPeopleAlive() + " PEOPLE");
        System.out.println("INFECTED - " + world.getInfectedPeople() + " PEOPLE");
        System.out.println("DIED - " + world.getDeadPeople() + " PEOPLE");
        System.out.println(" ");
        System.out.println("During 3 months: ");
        System.out.println("Infections: " + infectedPeopleDuringThreeMonths);
        System.out.println("Deaths: " + deadPeopleDuringThreeMonths);
        System.out.println("Recoveries: " + recoveredPeopleDuringThreeMonths);
        System.out.println("-".repeat(30));
        System.out.println(" ");
        System.out.println("Do you want to see the details of every country?");
        System.out.println("Press 'y' (yes) or 'n' (no): ");
        if (scanner.nextLine().equalsIgnoreCase("y")){
            System.out.println(" ");
            System.out.println("Actual infected in travel: " + world.getInfectedInTravel());
            System.out.println(" ");
            for (int i = 0; i < world.getAllCountries().size(); i++) {
                world.getAllCountries().get(i).printDetailInfo();
            }
        }
    }

    public static void printFirstReport(World world, Virus virus){
        System.out.println("-".repeat(30));
        System.out.println("Day: 0" );
        System.out.println("Amount of people - " + world.getPeopleAlive());
        System.out.println("Infected people - " + world.getInfectedPeople());
        System.out.println("-".repeat(30));
        System.out.println("The Plague begins!");
        System.out.println("Name of virus: "+virus.nameOfVirus());
        System.out.println("Starting virus in " + world.firstInfectedPerson());
        System.out.println("-".repeat(30));
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

}
