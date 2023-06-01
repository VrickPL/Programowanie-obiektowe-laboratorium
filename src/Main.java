import World.Reports.FirstReport;
import World.World;
import World.Reports.Report;
import World.Virus.Virus;

import java.io.FileNotFoundException;
import static World.Virus.ImplementingVirus.implementingVirus;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean toContinue = true;

        World world = new World();
        Report report = new Report();
        world.countryImplementing();
        Virus virus = implementingVirus();
        FirstReport.printFirstReport(world,virus);

        do{
            world.setDayCounter(world.getDayCounter()+1);
            world.anotherDay(virus, world, report);
            if (world.getDayCounter() % 90 == 0) {
                world.setPeople();
                report.duringThreeMonths(world, world.getDayCounter(),virus);
                toContinue=report.simulationContinue();
                report.newThreeMonths();
            }
            if(world.getInfectedPeople()<=0){
                System.out.println(" ");
                System.out.println("Humanity Won");
                System.out.println(" ");
            }


        }while(toContinue && world.getPeopleAlive()>0 && !world.isVaccineFound() && world.getInfectedPeople()>0 );
    }
}
