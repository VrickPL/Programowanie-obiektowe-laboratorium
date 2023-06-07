package World.Virus;

public record Virus(double timeOfMutation, double timeOfDisease, double factorOfContagious, double lethality,
                    String nameOfVirus) {
    public Virus(double timeOfMutation, double timeOfDisease, double factorOfContagious, double lethality, String nameOfVirus) {
        this.timeOfMutation = timeOfMutation;
        this.timeOfDisease = timeOfDisease;
        this.factorOfContagious = 1500 / factorOfContagious;
        this.lethality = 700 / lethality;
        this.nameOfVirus = nameOfVirus;
    }

    @Override
    public String toString() {
        return "Virus " + nameOfVirus + "have:\n\t" +
                timeOfDisease + " - time of disease,\n\t" +
                timeOfMutation + " - time of mutation\n\t" +
                lethality + " - lethality\n\t" +
                factorOfContagious + " - factor of contagious";
    }
}