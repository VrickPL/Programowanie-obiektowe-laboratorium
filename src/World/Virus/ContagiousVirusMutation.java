package World.Virus;

import static World.RandomEverything.setBoundOfRandomingTravel;

public class ContagiousVirusMutation extends Mutation {
    public ContagiousVirusMutation(double multiplierOfTimeOfMutation, double multiplierOfTimeOfDisease, double multiplierOfFactorOfContagious, double multiplierOfLethality) {
        super(multiplierOfTimeOfMutation, multiplierOfTimeOfDisease, multiplierOfFactorOfContagious, multiplierOfLethality);
    }

    @Override
    public Virus virusMutation(Virus oldVirus) {

        Virus newVirus = new Virus(oldVirus.timeOfMutation()* multiplierOfTimeOfMutation,
                oldVirus.timeOfDisease()* multiplierOfTimeOfDisease,
                oldVirus.factorOfContagious()* multiplierOfFactorOfContagious,
                oldVirus.lethality()*multiplierOfLethality,
                oldVirus.nameOfVirus());

        setBoundOfRandomingTravel(100);

        newChanceToFindVaccine(2); //it is harder to find a vaccine

        printInfo(newVirus);

        return newVirus;
    }



    @Override
    public void printInfo(Virus virus){
        super.printInfo(virus);
        System.out.println("Now the virus is more contagious! People don't want to travel so often.");
        System.out.println("New values of virus:");
        System.out.printf("Time of disease (days): %.2f\n", virus.timeOfDisease());
        System.out.printf("Factor of Contagious: %.2f\n", virus.factorOfContagious());
        System.out.printf("Time of Mutation (days): %.2f\n", virus.timeOfMutation());
        System.out.printf("Lethality: %.2f", virus.lethality());
        System.out.println(" ");
    }


}
