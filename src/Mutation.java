package Virus;

public class Mutation {

    public Virus mutation(Virus oldVirus){
        double multiplierOfTimeOfMutation = 1.1;
        double multiplierOfTimeOfDisease = 1.1;
        double multiplierOfFactorOfContagious = 1.1;
        double multiplierOfTimeOfIncubation = 1.1;
        return new Virus(oldVirus.getTimeOfMutation()* multiplierOfTimeOfMutation,
                oldVirus.getTimeOfDisease()* multiplierOfTimeOfDisease,
                oldVirus.getTimeOfIncubation()* multiplierOfTimeOfIncubation,
                oldVirus.getFactorOfContagious()* multiplierOfFactorOfContagious,
                oldVirus.getNameOfVirus());
    }
}
