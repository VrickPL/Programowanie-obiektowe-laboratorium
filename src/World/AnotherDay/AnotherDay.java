package World.AnotherDay;

import World.Person.Person;
import World.Reports.Report;
import World.Transport.Transport;
import World.Virus.Virus;
import World.World;

import java.util.ArrayList;
import java.util.Random;

import static World.AnotherDay.RandomEverything.*;
import static World.Transport.Transport.transport;

public class AnotherDay {
    public static void anotherDay(Virus virus, World world, Report report) {
        Random random = new Random();
        if(world.getThreeMonthsCounter() % 4 == 0 && world.getThreeMonthsCounter() != 0) newYear(world.getPeople());
        for (Person person : world.getPeople()) {
            randomEverything(virus, person,report);
            transport(person, world);
        }
        for (Transport transport : world.getTransports()) {
            if (transport.getTimeOfTravel() == world.getDayCounter()) {
                world.getPeople().get(random.nextInt(world.getPeople().size())).setInfected(true);
            }
        }
    }
    public static void randomEverything(Virus virus, Person person,Report report) {
        if (randomDie(virus, person)) {
            report.setDeadPeopleDuringThreeMonths(report.getDeadPeopleDuringThreeMonths()+1);
        }
        if (randomGetInfected(virus, person)) {
            report.setInfectedPeopleDuringThreeMonths(report.getInfectedPeopleDuringThreeMonths()+1);
        }
        if (recover(virus, person)) {
            report.setRecoveredPeopleDuringThreeMonths(report.getRecoveredPeopleDuringThreeMonths()+1);
        }
    }
    public static void newYear(ArrayList<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            people.get(i).setAge(people.get(i).getAge());
        }
    }
}
