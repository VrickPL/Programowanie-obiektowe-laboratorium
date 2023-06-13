package World.CreatingWorld;

import World.Country;
import World.Person.Person;
import World.World;
import java.util.ArrayList;

public class CreatingWorld {

    CreatingListOfCountries listOfCountries=new CreatingListOfCountries();
    CreatingListOfPeople listOfPeople=new CreatingListOfPeople();
    FirstInfection firstInfection=new FirstInfection();

    public void CreatingEntireWorld(World world){
        world.setAllCountries(listOfCountries.creatingListOfCountriesFromTXT());
        world.setPeople(listOfPeople.creatingPeople(world.getAllCountries()));
        world.setOutbreakOfTheEpidemic(firstInfection.firstInfectedPerson(world.getAllCountries(),world.getPeople()));
    }

}
