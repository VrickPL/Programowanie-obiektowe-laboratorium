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

    public int getDeadPeopleAmount() {
        return deadPeopleAmount;
    }

    public int getSickPeopleAmount() {
        return sickPeopleAmount;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void someoneDied(int alivePeopleAmount, int sickPeopleAmount, int deadPeopleAmount) {
        this.alivePeopleAmount = alivePeopleAmount-1;
        this.sickPeopleAmount = sickPeopleAmount-1;
        this.deadPeopleAmount = deadPeopleAmount+1;
    }

    public void someoneBorn(int alivePeopleAmount) {
        this.alivePeopleAmount = alivePeopleAmount+1;
    }

    public void someoneIsSick(int sickPeopleAmount) {
        this.sickPeopleAmount = sickPeopleAmount+1;
    }

    public void someoneRecover(int sickPeopleAmount) {
        this.sickPeopleAmount = sickPeopleAmount-1;
    }

    public void printInfo(){
        System.out.printf("In %s:\n", countryName);
        System.out.printf("Is alive %d people\n", alivePeopleAmount);
        System.out.printf("Died %d people\n", deadPeopleAmount);
        System.out.printf("Is sick %d people\n", sickPeopleAmount);
    }
}
