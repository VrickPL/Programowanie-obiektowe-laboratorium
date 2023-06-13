import World.AnotherDay.AnotherDay;
import World.CreatingWorld.CreatingWorld;
import World.World;
import World.Reports.Report;
import World.Virus.Virus;

import java.io.FileNotFoundException;
import static World.Virus.CreatingVirus.creatingVirus;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean toContinue = true;

        World world = new World();
        Report report = new Report();
        CreatingWorld creatingWorld=new CreatingWorld();

        creatingWorld.CreatingEntireWorld(world);
        Virus virus = creatingVirus();
        world.setPeople();
        Report.printFirstReport(world,virus);

        do{
            world.setDayCounter(world.getDayCounter()+1);
            AnotherDay.anotherDay(virus, world, report);
            if (world.getDayCounter() % 90 == 0) {
                world.setPeople();
                virus = report.duringThreeMonths(world, world.getDayCounter(), virus);
                toContinue=report.simulationContinue();
                report.newThreeMonths();
            }
            if(world.getInfectedPeople()<=0){
                System.out.println(" ");
                System.out.println("There's no more infected people");
                System.out.println("Humanity Won");
                System.out.println(" ");
            }


        }while(toContinue && world.getPeopleAlive()>0 && !world.isVaccineFound() && world.getInfectedPeople()>0 );
    }
}
