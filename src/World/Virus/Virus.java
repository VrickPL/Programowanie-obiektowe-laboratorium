package World.Virus;

public class Virus {
    private final double timeOfMutation;
    private final double timeOfDisease;
    private final double factorOfContagious;
    private final double lethality;
    private final String nameOfVirus;

    public Virus(double timeOfMutation, double timeOfDisease,double factorOfContagious,double lethality, String nameOfVirus) {
        this.timeOfMutation= timeOfMutation;
        this.timeOfDisease = timeOfDisease;
        this.factorOfContagious = factorOfContagious;
        this.lethality=lethality*100;
        this.nameOfVirus = nameOfVirus;
    }

    @Override
    public String toString() {
        return "Virus " +nameOfVirus+ "have:\n\t" +
                timeOfDisease + " - time of disease,\n\t"+
                timeOfMutation+" - time of mutation\n\t"+
                lethality+" - lethality\n\t"+
                factorOfContagious +" - factor of contagious";
    }

    public double getTimeOfMutation() {
        return timeOfMutation;
    }
    public double getTimeOfDisease() {
        return timeOfDisease;
    }
    public double getFactorOfContagious() {
        return factorOfContagious;
    }
    public String getNameOfVirus() {
        return nameOfVirus;
    }
    public double getLethality() {return lethality;}
}