import World.World;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        World world = new World();
        world.countryImplementing();
        boolean toContinue = true;
        Scanner scanner = new Scanner(System.in);


        while(toContinue && world.getPeopleAlive()>0 && !world.isVaccineFound()){
            world.duringThreeMonths();

            System.out.println(" ");
            System.out.println("Do you want to continue program?");
            System.out.println("Press 'y' (yes) or 'n' (no): ");
            if (!scanner.nextLine().toLowerCase().equals("y")) {
                toContinue = false;
            }
        }

    }
}
