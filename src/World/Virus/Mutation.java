package World.Virus;

import static World.AnotherDay.RandomEverything.getVaccinePercentageChance;
import static World.AnotherDay.RandomEverything.setVaccinePercentageChance;

public abstract class Mutation {
    double multiplierOfTimeOfMutation;
    double multiplierOfTimeOfDisease;
    double multiplierOfFactorOfContagious;
    double multiplierOfLethality;


    public Mutation(double multiplierOfTimeOfMutation, double multiplierOfTimeOfDisease, double multiplierOfFactorOfContagious, double multiplierOfLethality) {
        this.multiplierOfTimeOfMutation = multiplierOfTimeOfMutation;
        this.multiplierOfTimeOfDisease = multiplierOfTimeOfDisease;
        this.multiplierOfFactorOfContagious = multiplierOfFactorOfContagious;
        this.multiplierOfLethality = multiplierOfLethality;
    }

    Virus virusMutation(Virus oldVirus) {
        printInfo(oldVirus);
        return null;
    }

    void newChanceToFindVaccine(double multiplierOfNewVaccine){
        setVaccinePercentageChance((int) (getVaccinePercentageChance()*multiplierOfNewVaccine));
    }


    void printInfo(Virus virus){
        System.out.println("VIRUS MUTATED");
    }



}
