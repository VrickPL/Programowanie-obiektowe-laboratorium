package World.Person;
import World.Country;

public class Person {

    private static int personNumber = 1;
    private final int personIndex;
    private int age;
    private boolean alive = true;
    private boolean infected = false;
    private Country country;
    private int timeSinceInfection = 0;
    private boolean isInTransport = false;
    private int numberOfTransport;
    private int daysSinceTransport;

    public Person(int age, Country country) {
        this.personIndex = Person.personNumber++;
        this.age = age;
        this.country = country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setInTransport(boolean inTransport) {
        isInTransport = inTransport;
    }

    public boolean isInTransport() {
        return isInTransport;
    }

    public int getNumberOfTransport() {
        return numberOfTransport;
    }

    public void setNumberOfTransport(int numberOfTransport) {
        this.numberOfTransport = numberOfTransport;
    }

    public int getDaysSinceTransport() {
        return daysSinceTransport;
    }

    public void setDaysSinceTransport(int daysSinceTransport) {
        this.daysSinceTransport = daysSinceTransport;
    }

    public int getTimeSinceInfection() {
        return timeSinceInfection;
    }
    public void setTimeSinceInfection(int timeSinceInfection) {
        this.timeSinceInfection = timeSinceInfection;
    }
    public void setAge(int age) {
        if (isAlive()) this.age = age + 1;
    }
    public int getPersonIndex() {
        return personIndex;
    }
    public int getAge() {
        return age;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public void setInfected(boolean infected) {
        this.infected = infected;
    }
    public boolean isAlive() {
        return alive;
    }
    public boolean isInfected() {
        return infected;
    }
    public Country getCountry() {
        return country;
    }
}
