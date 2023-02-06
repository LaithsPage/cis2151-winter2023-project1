package proj1;
import java.time.LocalDate;

public class PersonHeartRate {

    private String firstName;
    private String lastName;
    private DateOfBirth birthInfo;
    private LocalDate currentDate;

    public PersonHeartRate(String firstName, String lastName, DateOfBirth birthInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthInfo = birthInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateOfBirth getBirthInfo() {
        return birthInfo;
    }

    public void setBirthInfo(DateOfBirth birthInfo) {
        this.birthInfo = birthInfo;
    }

    public int calculateAge(DateOfBirth birth) {

        //Instantiates LocalDate object based on system clock.
        //If the day changes during program execution, then the day will update when entering a new person's birthday!
        currentDate = LocalDate.now();

        //Current year - birth year = how many years have passed since your birth, NOT AGE
        //If birth day is before or on current day, return age, if birth day is after current month/day, then subtract 1

        int currentAge = currentDate.getYear() - birth.getBirthYear(); // current year - birth year = how many years have passed, NOT age

        //Check if your birth month has passed to correct age
        if(currentDate.getMonthValue() < birth.getBirthMonth()) { // If your birth month hasn't passed yet, currerntAge--
            currentAge--;
        }

        //Check if your birth day has passed to correct age
        // If your birth month is the current month, but your birthday hasn't come yet, currentAge--
        if(currentDate.getMonthValue() == birth.getBirthMonth() && currentDate.getDayOfMonth() < birth.getBirthDay()) {
            currentAge--;
        }

        return currentAge;
    }

    //Calculates max heart rate with the necessary formula
    public int calculateMaxHeartRate(int age) {

        return 220 - age;

    }

    //Calculates the target heart rate range and returns it with some formatting
    public String calculateTargetHeartRate(int maxHeartRate) {

        Double lowEndOfRange;
        Double highEndOfRange;
        String heartRateRange;

        lowEndOfRange = maxHeartRate * 0.50;
        highEndOfRange = maxHeartRate * 0.85;



        heartRateRange = lowEndOfRange + " - " + highEndOfRange;

        return heartRateRange;
    }

    //Will print the name, max heart rate, and target heart rate range of a given PersonHeartRate instance
    public void printData(PersonHeartRate personToPrint) {

        //Only variable needed to be called later is the max heart rate. Can just
        int personMaxHeartRate = personToPrint.calculateMaxHeartRate(personToPrint.calculateAge(personToPrint.getBirthInfo()));

        //Print it all
        System.out.println(personToPrint.getLastName() + ", " + personToPrint.getFirstName()
        + "\n" + personMaxHeartRate + "\n" + personToPrint.calculateTargetHeartRate(personMaxHeartRate) + "\n");

    }

}
