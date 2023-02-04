package proj1;

import java.util.ArrayList;

public class HeartRateDemo {

    private final ArrayList<PersonHeartRate> listOfPeople = new ArrayList<PersonHeartRate>();

    public static void main(String[] args) {

        DateOfBirth meow = new DateOfBirth(6, 25, 1997);
        PersonHeartRate Laith = new PersonHeartRate("Laith", "Riley", meow);
        System.out.println(Laith.calculateAge(meow));
        System.out.println(Laith.calculateTargetHeartRate(Laith.calculateMaxHeartRate(Laith.calculateAge(Laith.getBirthInfo()))));
    }

    public String calculateItAll(PersonHeartRate personData) {
        return "meow";
    }

}
