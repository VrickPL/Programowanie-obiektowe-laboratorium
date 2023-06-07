package World;

import World.Person.Person;


public class Country {
    private String countryName;
    private int alivePeopleAmount;
    private int deadPeopleAmount = 0;
    private int sickPeopleAmount = 0;
    private int infectedPeopleInTransport = 0;

    private final boolean isAirport;
    private final boolean isHarbor;

    public Country(String countryName, int alivePeopleAmount,boolean isAirport, boolean isHarbor) {
        this.countryName = countryName;
        this.alivePeopleAmount = alivePeopleAmount;
        this.isAirport=isAirport;
        this.isHarbor=isHarbor;
    }
    public Country(String countryName, int alivePeopleAmount){
        this(countryName,alivePeopleAmount, alivePeopleAmount % 2 == 0, alivePeopleAmount % 3 == 0);
    }

    public void setSickPeopleAmount(int sickPeopleAmount) {
        this.sickPeopleAmount = sickPeopleAmount;
    }

    public void setInfectedPeopleInTransport(int infectedPeopleInTransport) {
        this.infectedPeopleInTransport = infectedPeopleInTransport;
    }

    public boolean isAirport() {
        return isAirport;
    }

    public boolean isHarbor() {
        return isHarbor;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getAlivePeopleAmount() {
        return alivePeopleAmount;
    }

    public int getDeadPeopleAmount() {
        return deadPeopleAmount;
    }

    public int getSickPeopleAmount() {
        return sickPeopleAmount;
    }

    public int getInfectedPeopleInTransport() {
        return infectedPeopleInTransport;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void someoneDied() {
        alivePeopleAmount--;
        sickPeopleAmount--;
        deadPeopleAmount++;
    }

    public void someoneIsSick() {
        sickPeopleAmount++;
    }

    public void someoneRecover() {
        sickPeopleAmount--;
    }

    public void someoneIsSickInTransport(){
        infectedPeopleInTransport++;
    }

    public void diedInTransport(){
        infectedPeopleInTransport--;
        alivePeopleAmount--;
        deadPeopleAmount++;
    }

    public void recoveredInTransport(){
        infectedPeopleInTransport--;
    }

    public void endOfTheTransportAndPersonIsSick(){
        infectedPeopleInTransport--;
        sickPeopleAmount++;
    }

    public void printDetailInfo(){
        System.out.println(" ");
        System.out.printf("In %s:\n", countryName);
        System.out.printf("Alive - %d people\n", alivePeopleAmount);
        System.out.printf("Died - %d people\n", deadPeopleAmount);
        System.out.printf("Infected - %d people\n", (sickPeopleAmount + infectedPeopleInTransport));
    }
    public static boolean isInfectedInCountry(Person person){
        return (person.getCountry().getSickPeopleAmount() > 0);
    }

    public void newHumanInTheCountry(){
        alivePeopleAmount++;
    }

    public void someoneLeftTheCountry(Person person){
        alivePeopleAmount--;
        if(person.isInfected()){
            sickPeopleAmount--;
        }
    }
}
