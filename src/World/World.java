package World;

import World.Person.Person;
import World.Reports.Report;
import World.Transport.Transport;
import World.Virus.Virus;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static World.Transport.Transport.transport;


public class World {

    private ArrayList<Country> allCountries = new ArrayList<>();
    private ArrayList<Person> people = new ArrayList<>();
    ArrayList<Transport> transports = new ArrayList<>();
    private int dayCounter = 0;
    private int peopleAlive = 0;
    private int deadPeople = 0;
    private int infectedPeople = 0;
    private int infectedInTravel = 0;
    private boolean vaccineFound = false;
    private int threeMonthsCounter = 0;
    private String outbreakOfTheEpidemic;

    public int getPeopleAlive() {
        if (peopleAlive <= 0) {
            System.out.println(" ");
            System.out.println("THERE IS NO HUMAN LEFT");
            System.out.println(" ");
        }
        return peopleAlive;
    }
    public boolean isVaccineFound() {
        if (vaccineFound) {
            System.out.println(" ");
            System.out.println("VACCINE FOUND");
            System.out.println(" ");
        }
        return vaccineFound;
    }
    public static Country getRandomCountry(World world) {
        Random random = new Random();
        return world.getAllCountries().get(random.nextInt(world.getAllCountries().size()));
    }
    public void setPeople() {
        peopleAlive = 0;
        deadPeople = 0;
        infectedPeople = 0;
        infectedInTravel = 0;

        for (int i = 0; i < allCountries.size(); i++) {
            peopleAlive += allCountries.get(i).getAlivePeopleAmount();
            deadPeople += allCountries.get(i).getDeadPeopleAmount();
            if (allCountries.get(i).getSickPeopleAmount() < 0) allCountries.get(i).setSickPeopleAmount(0);
            if (allCountries.get(i).getInfectedPeopleInTransport() < 0)
                allCountries.get(i).setInfectedPeopleInTransport(0);
            infectedPeople += allCountries.get(i).getSickPeopleAmount() + allCountries.get(i).getInfectedPeopleInTransport();
            infectedInTravel += allCountries.get(i).getInfectedPeopleInTransport();
        }
    }

    public ArrayList<Country> getAllCountries() {
        return allCountries;
    }

    public int getThreeMonthsCounter() {
        return threeMonthsCounter;
    }

    public void setThreeMonthsCounter(int threeMonthsCounter) {
        this.threeMonthsCounter = threeMonthsCounter;
    }

    public String getOutbreakOfTheEpidemic() {
        return outbreakOfTheEpidemic;
    }

    public void setOutbreakOfTheEpidemic(String outbreakOfTheEpidemic) {
        this.outbreakOfTheEpidemic = outbreakOfTheEpidemic;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setAllCountries(ArrayList<Country> allCountries) {
        this.allCountries = allCountries;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public int getDayCounter() {
        return dayCounter;
    }

    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }

    public ArrayList<Transport> getTransports() {
        return transports;
    }

    public int getDeadPeople() {
        return deadPeople;
    }

    public int getInfectedPeople() {
        return infectedPeople;
    }

    public int getInfectedInTravel() {
        return infectedInTravel;
    }
    public void setVaccineFound(boolean vaccineFound) {
        this.vaccineFound = vaccineFound;
    }
}