package World.CreatingWorld;

import World.Country;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CreatingListOfCountries {
    public ArrayList<Country> creatingListOfCountriesFromTXT() {

        ArrayList<Country> allCountries=new ArrayList<>();
        creatingCountries(allCountries,readTextFromFile("CountriesPO.txt"));
        return allCountries;
    }
    void creatingCountries(ArrayList<Country> allCountries,List<String> listOfCountries){
        for (int i=0;i<listOfCountries.size();i++) {
            String[] splittedFileLine = listOfCountries.get(i).split(" ");
            Country country = new Country(splittedFileLine[0], Integer.parseInt(splittedFileLine[1]));
            allCountries.add(country);

            //creating countries from "country.txt" file

            while (allCountries.get(i).getCountryName().contains("_")) {
                String[] twoWordCountry = allCountries.get(i).getCountryName().split("_");
                allCountries.get(i).setCountryName(String.join(" ", twoWordCountry[0], twoWordCountry[1]));
            }
        }
    }
    List<String> readTextFromFile(String fileName) {
        List<String> content = null;
        try {
            content = Files.readAllLines(Path.of(fileName), StandardCharsets.UTF_8);
            System.out.println("file with countries is successfully read");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
