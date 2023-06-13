package World.Virus;

import World.GetTextFromUser;

import java.util.Scanner;

public class CreatingVirus implements GetTextFromUser {
    public static Virus creatingVirus() {
        System.out.println("Make your own Virus!");

        System.out.print("Enter his name: ");
        String name= GetTextFromUser.takeDataFromKeyboard();

        System.out.println("Do you want to use default settings? Enter \"yes\" or \"no\"");
        System.out.print("Enter: ");
        String whatToDo = GetTextFromUser.takeDataFromKeyboard();

        if(whatToDo.equals("yes")){
            return new Virus(100, 50, 5, 5, name);
        } else if (whatToDo.equals("no")) {
            System.out.println("Enter factors of your own Virus ( should be positive;-) )");
            System.out.print("Enter time of disease (days): ");
            int timeOfDisease=Math.abs(Integer.parseInt(GetTextFromUser.takeDataFromKeyboard()));
            System.out.print("Enter factor of Contagious (1 - 10): ");
            double factorOfContagious=Math.abs(Double.parseDouble(GetTextFromUser.takeDataFromKeyboard()));
            System.out.print("Enter time of Mutation (days): ");
            double timeOfMutation=Math.abs(Double.parseDouble(GetTextFromUser.takeDataFromKeyboard()));
            System.out.print("Enter lethality (1 - 10): ");
            double lethality=Math.abs(Double.parseDouble(GetTextFromUser.takeDataFromKeyboard()));
            return new Virus(timeOfMutation, timeOfDisease,factorOfContagious,lethality,name);
        } else {
            System.out.println("Wrong string entered. Using default settings.");
            return new Virus(100, 50, 5, 5, name);
        }
    }


}
