package World.Virus;

import java.util.Scanner;

public class CreatingVirus {
    public static Virus creatingVirus() {
        System.out.println("Make your own Virus!");

        System.out.print("Enter his name: ");
        String name= takeDataFromKeyboard();

        System.out.println("Do you want to use default settings? Enter \"yes\" or \"no\"");
        System.out.print("Enter: ");
        String whatToDo = takeDataFromKeyboard();

        if(whatToDo.equals("yes")){
            return new Virus(100, 50, 5, 5, name);
        } else if (whatToDo.equals("no")) {
            System.out.print("Enter time of disease (days): ");
            int timeOfDisease=Integer.parseInt(takeDataFromKeyboard());
            System.out.print("Enter factor of Contagious (1 - 10): ");
            double factorOfContagious=Double.parseDouble(takeDataFromKeyboard());
            System.out.print("Enter time of Mutation (days): ");
            double timeOfMutation=Double.parseDouble(takeDataFromKeyboard());
            System.out.print("Enter lethality (1 - 10): ");
            double lethality=Double.parseDouble(takeDataFromKeyboard());
            return new Virus(timeOfMutation, timeOfDisease,factorOfContagious,lethality,name);
        } else {
            System.out.println("Wrong string entered. Using default settings.");
            return new Virus(100, 50, 5, 5, name);
        }
    }
    private static String takeDataFromKeyboard(){
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
