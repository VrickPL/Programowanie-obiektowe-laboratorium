package World.Person;

import java.util.Random;

public class Person {
    private static int personNumber = 1;
    private final int personIndex;
    private int age;
    private boolean alive = true;
    private boolean infected = false;
    private String country;
    protected Random random = new Random();


    public Person(int age, String country) {
        this.personIndex = Person.personNumber++;
        this.age = age;
        this.country = country;
    }

    public void setAge(int age) {
        if (isAlive()) this.age = age+1;
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

    public double dieAgeMultiplier(){
        if(age<18){
            return 1;
        } else if(age<60){
            return 2;
        } else{
            return 5;
        }
    }
    public boolean randomDie(){
        if(isAlive() && isInfected()){
            if(random.nextInt(10) + 1 <= 1* dieAgeMultiplier()){
                setAlive(false);
                return true;
            }
        }
        return false;
    }

    public boolean randomGetInfected(){
        if(isAlive() && !isInfected()){
            if(random.nextInt(10) + 1 <= 1* dieAgeMultiplier()){
                setAlive(false);
                return true;
            }
        }
        return false;
    }

    public boolean recover(){
        if(isAlive() && isInfected()){
            if(random.nextInt(100) + 1 <= 20/ dieAgeMultiplier()){
                setAlive(false);
                return true;
            }
        }
        return false;
    }

    public double transportAgeMultiplier(){
        if(age<18){
            return 5;
        } else if(age<60){
            return 1;
        } else{
            return 5;
        }
    }

    public boolean randomTransport(){
        //TRZEBA UZUPELNIC
        //wazne jeszcze ze jak ktos sie transportuje to zmniejsza sie liczba osob w kraju danym i zwieksza w tym nowym (w zarazonych i zywych ogolnie)
        if(isAlive() && (random.nextInt(100) + 1<= 10/transportAgeMultiplier())){
            int whichTransport = 1 + random.nextInt(3);
            switch(whichTransport){
                case 1 -> {
                    //car
                }
                case 2 -> {
                    //ship
                }
                case 3 -> {
                    //plane
                }
            }
            return true;
        }
        return false;
    }
}
