package Virus;

public class Virus {
    private final double timeOfMutation;
    private final double timeOfDisease;
    private final double timeOfIncubation;
    private final double factorOfContagious;
    private final String nameOfVirus;

    public Virus(double timeOfMutation, double timeOfDisease, double timeOfIncubation, double factorOfContagious, String nameOfVirus) {
        this.timeOfMutation = timeOfMutation;
        this.timeOfDisease = timeOfDisease;
        this.timeOfIncubation = timeOfIncubation;
        this.factorOfContagious = factorOfContagious;
        this.nameOfVirus = nameOfVirus;
    }

    @Override
    public String toString() {
        return "Virus " +nameOfVirus+ "have:\n\t" +
                timeOfDisease + " - time of disease,\n\t"+
                timeOfIncubation+ " - time of incubation,\n\t"+
                timeOfMutation+" - time of mutation\n\t"+
                factorOfContagious +" - factor of contagious";
    }

    public double getTimeOfMutation() {
        return timeOfMutation;
    }

    public double getTimeOfDisease() {
        return timeOfDisease;
    }

    public double getTimeOfIncubation() {
        return timeOfIncubation;
    }

    public double getFactorOfContagious() {
        return factorOfContagious;
    }

    public String getNameOfVirus() {
        return nameOfVirus;
    }
}
