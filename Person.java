package Person;

public class Person {
    private static int personNumber = 1;
    private final int personIndex;
    private int age;


    public Person(int age) {
        this.personIndex = Person.personNumber++;
        this.age = age;
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


;