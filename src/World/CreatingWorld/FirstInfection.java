package World.CreatingWorld;

import World.Country;
import World.GetTextFromUser;
import World.Person.Person;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FirstInfection {
    public int chooseFirstInfectedCountry(ArrayList<Country> allCountries){
        Random random = new Random();
        System.out.println("Where do you want to start a virus? Enter a country name or type \"random\" ");
        System.out.print("Enter: ");
        String name = GetTextFromUser.takeDataFromKeyboard();
        if(name.isEmpty() || name.equals("random")) return random.nextInt(allCountries.size());
        for (int i = 0; i < allCountries.size(); i++) {
            if(name.equalsIgnoreCase(allCountries.get(i).getCountryName())){
                return i;
            }
        }
        System.out.println("Wrong country name, selecting random country...");
        return random.nextInt(allCountries.size());
    }

    public String firstInfectedPerson(ArrayList<Country> allCountries,ArrayList<Person> people ) {
        int indexOfCountry = chooseFirstInfectedCountry(allCountries);
        for(Person person : people){
            if(person.getCountry().equals(allCountries.get(indexOfCountry))){
                person.setInfected(true);
                person.getCountry().someoneIsSick();
                break;
            }
        }
        return allCountries.get(indexOfCountry).getCountryName();
    }
}
