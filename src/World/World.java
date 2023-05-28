package World;

import World.Person.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class World {

    ArrayList<Country> allCountries = new ArrayList<>();
    ArrayList<Person> people = new ArrayList<>();
    private int peopleAlive = 0;
    private int deadPeople = 0;
    private int deadPeopleDuringThreeMonths = 0;
    private int infectedPeople = 0;
    private int infectedPeopleDuringThreeMonths = 0;
    private int peopleTransportedDuringThreeMonths = 0;
    private int recoveredPeopleDuringThreeMonths = 0;
    private boolean vaccineFound = false;
    private int threeMonthsCounter = 0;
    Scanner scanner = new Scanner(System.in);
    protected Random random = new Random();


    public int getPeopleAlive() {
        return peopleAlive;
    }

    public boolean isVaccineFound() {
        return vaccineFound;
    }

    public void countryImplementing() throws FileNotFoundException {
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
            System.out.println("World.Country: " + allCountries.get(i).getCountryName());
            System.out.printf("Alive: %d people\n", allCountries.get(i).getAlivePeopleAmount());
            System.out.println(" ");
            peopleAlive += allCountries.get(i).getAlivePeopleAmount();

            //creating people for all countries
            for (int j = 0; j < allCountries.get(i).getAlivePeopleAmount(); j++) {
                Person newHuman = new Person((random.nextInt(140)+1), allCountries.get(i).getCountryName());
                people.add(newHuman);
            }

            i++;
        }
    }

    public void setVaccineFound(boolean vaccineFound) {
        this.vaccineFound = vaccineFound;
    }

    public void randomVaccineFound(){
        int maxValue = 100;
        //if(liczbaMutacjiWirusa>0) maxValue *= 1.3;
        //jesli wirus mutuje to tez sie zmniejsza szansa na szczepionke
        if(random.nextInt(maxValue) == 1) setVaccineFound(true);
    }

    public void duringThreeMonths(){
        threeMonthsCounter++;
        deadPeopleDuringThreeMonths = 0;
        infectedPeopleDuringThreeMonths = 0;
        peopleTransportedDuringThreeMonths = 0;
        recoveredPeopleDuringThreeMonths = 0;

        //jesli ktos umrze lub zachoruje to zmieniaja sie dane w kraju
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).randomDie()) {
                deadPeopleDuringThreeMonths++;
                boolean toContinue = true;
                for (int j = 0; toContinue; j++) {
                    if(allCountries.get(j).getCountryName().equals(people.get(i).getCountry())){
                        allCountries.get(j).someoneDied();
                        toContinue = false;
                    }
                }
            }

            if(people.get(i).randomGetInfected()) {
                infectedPeopleDuringThreeMonths++;
                boolean toContinue = true;
                for (int j = 0; toContinue; j++) {
                    if(allCountries.get(j).getCountryName().equals(people.get(i).getCountry())){
                        allCountries.get(j).someoneIsSick();
                        toContinue = false;
                    }
                }
            }

            if(people.get(i).recover()){
                recoveredPeopleDuringThreeMonths++;
                boolean toContinue = true;
                for (int j = 0; toContinue; j++) {
                    if(allCountries.get(j).getCountryName().equals(people.get(i).getCountry())){
                        allCountries.get(j).someoneRecover();
                        toContinue = false;
                    }
                }
            }

            if(people.get(i).randomTransport()) peopleTransportedDuringThreeMonths++;
        }
        peopleAlive -= deadPeopleDuringThreeMonths;
        deadPeople += deadPeopleDuringThreeMonths;
        infectedPeople += infectedPeopleDuringThreeMonths;

        //MUTACJA WIRUSA

        randomVaccineFound();

        printInfo();

        if(threeMonthsCounter % 4 == 0 && threeMonthsCounter != 0) newYear();
    }

    public void printInfo(){
        System.out.println("-".repeat(30));
        System.out.println("Date: "); //dodac date co sie zmienia co 3 miesiace
        System.out.println("ALIVE - " + peopleAlive + " PEOPLE");
        System.out.println("INFECTED - " + infectedPeople + " PEOPLE");
        System.out.println("DIED - " + deadPeople + " PEOPLE");
        System.out.println(" ");
        System.out.println("During 3 months: ");
        System.out.println("Infected - " + infectedPeopleDuringThreeMonths + " people");
        System.out.println("Died - " + deadPeopleDuringThreeMonths + " people");
        System.out.println("Recovered - " + recoveredPeopleDuringThreeMonths + " people");
        System.out.println("People transported - " + peopleTransportedDuringThreeMonths);
        System.out.println("-".repeat(30));
        System.out.println(" ");
        System.out.println("Do you want to see the details of every country?");
        System.out.println("Press 'y' (yes) or 'n' (no): ");
        if (scanner.nextLine().toLowerCase().equals("y")){
            for (int i = 0; i < allCountries.size(); i++) {
                allCountries.get(i).printDetailInfo();
            }
        }
    }

    public void newYear(){
        for (int i = 0; i < people.size(); i++) {
            people.get(i).setAge(people.get(i).getAge());
        }
    }
}
