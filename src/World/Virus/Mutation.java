package World.Virus;

public class Mutation {

    public static Virus virusMutation(Virus oldVirus){
        System.out.println("Virus mutates");
        double multiplierOfTimeOfMutation = 1* oldVirus.getTimeOfMutation();
        double multiplierOfTimeOfDisease = 1* oldVirus.getTimeOfMutation();
        double multiplierOfFactorOfContagious = 1* oldVirus.getTimeOfMutation();
        double multiplierOfLethality = 1* oldVirus.getTimeOfMutation();
        return new Virus(oldVirus.getTimeOfMutation()* multiplierOfTimeOfMutation,
                oldVirus.getTimeOfDisease()* multiplierOfTimeOfDisease,
                oldVirus.getFactorOfContagious()* multiplierOfFactorOfContagious,
                oldVirus.getLethality()*multiplierOfLethality,
                oldVirus.getNameOfVirus());
    }
}
