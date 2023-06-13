package World.Virus;

public class DeadlyVirusMutation extends Mutation {
    public DeadlyVirusMutation(double multiplierOfTimeOfMutation, double multiplierOfTimeOfDisease, double multiplierOfFactorOfContagious, double multiplierOfLethality) {
        super(multiplierOfTimeOfMutation, multiplierOfTimeOfDisease, multiplierOfFactorOfContagious, multiplierOfLethality);
    }

    @Override
    public Virus virusMutation(Virus oldVirus) {

        Virus newVirus = new Virus(oldVirus.timeOfMutation()* multiplierOfTimeOfMutation,
                oldVirus.timeOfDisease()* multiplierOfTimeOfDisease,
                oldVirus.factorOfContagious()* multiplierOfFactorOfContagious,
                oldVirus.lethality()*multiplierOfLethality,
                oldVirus.nameOfVirus());

        newChanceToFindVaccine(0.5); //people want to find a vaccine

        printInfo(newVirus);

        return newVirus;
    }

    @Override
     public void printInfo(Virus virus){
        super.printInfo(virus);
        System.out.println("Now the virus is very deadly! People are scary and more people try to find a vaccine!");
        System.out.println("New values of virus:");
        System.out.printf("Time of disease (days): %.2f\n", virus.timeOfDisease());
        System.out.printf("Factor of Contagious: %.2f\n", virus.factorOfContagious());
        System.out.printf("Time of Mutation (days): %.2f\n", virus.timeOfMutation());
        System.out.printf("Lethality: %.2f\n", virus.lethality());
        System.out.println(" ");
     }
}
