package Person;

public class Person {
    private static int personNumber = 1;
    private final int personIndex;
    private int age;
    private boolean alive = true;
    private boolean infected = false;
    private String country;


    public Person(int age, String country) {
        this.personIndex = Person.personNumber++;
        this.age = age;
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age+1;
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

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isInfected() {
        return infected;
    }

    public String getCountry() {
        return country;
    }

    public double ageMultiplier(){
        if(age<18){
            return 1;
        } else if(age<60){
            return 1.5;
        } else{
            return 3;
        }
    }
}
