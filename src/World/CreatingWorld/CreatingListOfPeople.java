package World.CreatingWorld;

import World.Country;
import World.Person.Person;

import java.util.ArrayList;
import java.util.Random;

public class CreatingListOfPeople {
    ArrayList<Person> creatingPeople(ArrayList<Country>allCountries){
        Random random = new Random();
        ArrayList<Person> people = new ArrayList<Person>();
        for (Country country : allCountries) {
            for (int j = 0; j < country.getAlivePeopleAmount(); j++) {
                Person newHuman = new Person((random.nextInt(140) + 1), country);
                people.add(newHuman);
            }
        }
        return people;
    }
}
