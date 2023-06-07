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

    ArrayList<Country> allCountries = new ArrayList<>();
    ArrayList<Person> people = new ArrayList<>();
    ArrayList<Transport> transports = new ArrayList<>();
    private int dayCounter=0;
    private int peopleAlive = 0;
    private int deadPeople = 0;
    private int infectedPeople = 0;
    private int infectedInTravel = 0;
    private boolean vaccineFound = false;
    protected Random random = new Random();
    private int threeMonthsCounter=0;


    public int getPeopleAlive() {
        if(peopleAlive<=0){
            System.out.println(" ");
            System.out.println("THERE IS NO HUMAN LEFT");
            System.out.println(" ");
        }
        return peopleAlive;
    }

    public boolean isVaccineFound() {
        if(vaccineFound) {
            System.out.println(" ");
            System.out.println("VACCINE FOUND");
            System.out.println(" ");
        }
        return vaccineFound;
    }

    public static Country getRandomCountry(World world){
        Random random = new Random();
        return world.getAllCountries().get(random.nextInt(world.getAllCountries().size()));
    }

    public void anotherDay(Virus virus, World world, Report report){
        for(Person person: people){
            report.randomEverything(virus, person);
            transport(person,world);
        }

        for (Transport transport:transports) {
            if(transport.getTimeOfTravel()==world.dayCounter){
                people.get(random.nextInt(people.size())).setInfected(true);
            }
        }
    }

    public void creatingListOfCountriesFromTXT() throws FileNotFoundException {
        File file = new File("CountriesPO.txt");
        Scanner fileScanner = new Scanner(file);
        Country country;

        int i = 0;
        while(fileScanner.hasNext()){
            String fileLine = fileScanner.nextLine();
            String[] splittedFileLine = fileLine.split(" ");
            country = new Country(splittedFileLine[0], Integer.parseInt(splittedFileLine[1]));
            allCountries.add(country);
            //creating countries from "country.txt" file
            while(allCountries.get(i).getCountryName().contains("_")){
                String[] twoWordCountry = allCountries.get(i).getCountryName().split("_");
                allCountries.get(i).setCountryName(String.join(" ", twoWordCountry[0], twoWordCountry[1]));
            }
            peopleAlive += allCountries.get(i).getAlivePeopleAmount();

            //creating people for all countries
            for (int j = 0; j < allCountries.get(i).getAlivePeopleAmount(); j++) {
                Person newHuman = new Person((random.nextInt(140)+1), allCountries.get(i));
                people.add(newHuman);
            }

            i++;
        }
    }

    public void setVaccineFound(boolean vaccineFound) {
        this.vaccineFound = vaccineFound;
    }


    public void newYear(){
        for (int i = 0; i < people.size(); i++) {
            people.get(i).setAge(people.get(i).getAge());
        }
    }

    public int getDayCounter() {
        return dayCounter;
    }
    public void setDayCounter(int dayCounter){this.dayCounter=dayCounter;}
    public ArrayList<Transport> getTransports() {return transports;}
    public int getDeadPeople() {
        return deadPeople;
    }
    public int getInfectedPeople() {
        return infectedPeople;
    }

    public int getInfectedInTravel() {
        return infectedInTravel;
    }

    public void setPeople(){
        peopleAlive = 0;
        deadPeople = 0;
        infectedPeople = 0;
        infectedInTravel = 0;

        for (int i = 0; i < allCountries.size(); i++) {
            peopleAlive += allCountries.get(i).getAlivePeopleAmount();
            deadPeople += allCountries.get(i).getDeadPeopleAmount();
            if(allCountries.get(i).getSickPeopleAmount()<0) allCountries.get(i).setSickPeopleAmount(0);
            if(allCountries.get(i).getInfectedPeopleInTransport()<0) allCountries.get(i).setInfectedPeopleInTransport(0);
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

    public int firstInfectedCountry(ArrayList<Country> allCountries){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where do you want to start a virus? Enter a country name or type \"random\" ");
        System.out.print("Enter: ");
        String name = scanner.nextLine();
        if(name.isEmpty() || name.equals("random")) return random.nextInt(allCountries.size());

        for (int i = 0; i < allCountries.size(); i++) {
            if(name.equalsIgnoreCase(allCountries.get(i).getCountryName())){
                return i;
            }
        }
        System.out.println("Wrong country name, selecting random country...");
        return random.nextInt(allCountries.size());
    }

    public String firstInfectedPerson() {
        int indexOfCountry = firstInfectedCountry(allCountries);
        for(Person person : people){
            if(person.getCountry().equals(allCountries.get(indexOfCountry))){
                person.setInfected(true);
                person.getCountry().someoneIsSick();
                setPeople();
                break;
            }
        }
        return allCountries.get(indexOfCountry).getCountryName();
    }

}