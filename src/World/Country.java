package World;

public class Country {
    private String countryName;
    private int alivePeopleAmount;
    private int deadPeopleAmount = 0;
    private int sickPeopleAmount = 0;

    public Country(String countryName, int alivePeopleAmount) {
        this.countryName = countryName;
        this.alivePeopleAmount = alivePeopleAmount;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getAlivePeopleAmount() {
        return alivePeopleAmount;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void someoneDied() {
        alivePeopleAmount--;
        sickPeopleAmount--;
        deadPeopleAmount++;
    }

    public void someoneBorn() { //nie wiem czy to chcemy
        alivePeopleAmount++;
    }

    public void someoneIsSick() {
        sickPeopleAmount++;
    }

    public void someoneRecover() {
        sickPeopleAmount--;
    }

    public void printDetailInfo(){
        System.out.printf("In %s:\n", countryName);
        System.out.printf("Alive - %d people\n", alivePeopleAmount);
        System.out.printf("Died - %d people\n", deadPeopleAmount);
        System.out.printf("Infected - %d people\n", sickPeopleAmount);
    }
}
