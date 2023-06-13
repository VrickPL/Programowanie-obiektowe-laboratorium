package World;

import java.util.Scanner;

public interface GetTextFromUser {
    static String takeDataFromKeyboard(){
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
