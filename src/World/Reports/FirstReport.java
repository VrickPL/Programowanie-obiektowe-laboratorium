package World.Reports;
import World.Virus.Virus;
import World.World;

public class FirstReport {
    public static void printFirstReport(World world, Virus virus){
        System.out.println("-".repeat(30));
        System.out.println("Day: 0" );
        System.out.println("Amount of people - " + world.getPeopleAlive());
        System.out.println("Infected people - " + world.getInfectedPeople());
        System.out.println("-".repeat(30));
        System.out.println("The Plague begins!");
        System.out.println("Name of virus: "+virus.getNameOfVirus());
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
