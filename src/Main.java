import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Country> allCountries = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        countryImplementing();




    }

    public static void countryImplementing() throws FileNotFoundException {
        File file = new File("CountriesPO.txt");
        Scanner fileScanner = new Scanner(file);
        Country country;

        int i = 0;
        while(fileScanner.hasNext()){
            String fileLine = fileScanner.nextLine();
            String[] splittedFileLine = fileLine.split(" ");
            country = new Country(splittedFileLine[0], Integer.parseInt(splittedFileLine[1]));
            allCountries.add(country);
            System.out.println("Country: " + allCountries.get(i).getCountryName());
            System.out.printf("Alive: %d people\n", allCountries.get(i).getAlivePeopleAmount());
            System.out.println("");
            while(allCountries.get(i).getCountryName().contains("_")){
                String[] twoWordCountry = allCountries.get(i).getCountryName().split("_");
                allCountries.get(i).setCountryName(String.join(" ", twoWordCountry[0], twoWordCountry[1]));
            }
            i++;
        }
    }
}
