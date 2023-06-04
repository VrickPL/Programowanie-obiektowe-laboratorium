package World.Virus;

import java.util.Scanner;

public class ImplementingVirus {
    public static Virus implementingVirus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Make your own Virus!");

        System.out.print("Enter his name: ");
        String name= dataInput();

        System.out.println("Do you want to use default settings? Enter \"yes\" or \"no\"");
        System.out.print("Enter: ");
        String whatToDo = scanner.nextLine().toLowerCase();
        if(whatToDo.equals("yes")){
            return new Virus(1, 1, 1, 1, name);
        } else if (whatToDo.equals("no")) {
            System.out.print("Enter time of disease: ");
            int timeOfDisease=Integer.parseInt(dataInput());
            System.out.print("Enter factor of Contagious: ");
            double factorOfContagious=Double.parseDouble(dataInput());
            System.out.print("Enter time of Mutation: ");
            double timeOfMutation=Double.parseDouble(dataInput());
            System.out.print("Enter lethality: ");
            double lethality=Double.parseDouble(dataInput());
            return new Virus(timeOfMutation, timeOfDisease,factorOfContagious,lethality,name);
        } else {
            System.out.println("Wrong string entered. Using default settings.");
            return new Virus(1, 1, 1, 1, name);
        }
    }
    private static String dataInput(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while (name.isEmpty()){
            System.out.println("Ops, something goes wrong, try again");
            System.out.print("Enter: ");
            name = scanner.nextLine();
        }
        return name;
    }

}

