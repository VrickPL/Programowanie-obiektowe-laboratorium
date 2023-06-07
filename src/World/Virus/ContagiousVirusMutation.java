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
        System.out.println("Time of disease (days): " + virus.timeOfDisease());
        System.out.println("Factor of Contagious: " + virus.factorOfContagious());
        System.out.println("Time of Mutation (days): " + virus.timeOfMutation());
        System.out.println("Lethality: " + virus.lethality());
        System.out.println(" ");
    }


}
