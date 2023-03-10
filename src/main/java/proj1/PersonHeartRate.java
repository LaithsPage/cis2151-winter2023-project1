package proj1;
import java.time.LocalDate;

/**
 * Proj1
 * Author: Jacob "Laith" Riley
 * Class: CIS 2151
 * Prof: Dr. J
 */
public class PersonHeartRate {

    private String firstName;
    private String lastName;
    private DateOfBirth birthInfo;
    private LocalDate currentDate;

    //Class constructor
    public PersonHeartRate(String firstName, String lastName, DateOfBirth birthInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthInfo = birthInfo;
    }

    //Get and Set methods below
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


    //Method for calculating user's age. currentDate field is initialized to user's system clock using LocalDate.
    //If the user leaves the program open and then comes back and enters new information, the current date will still be accurate.
    //Will check if user's bday has passed the current day or not to accurately calculate information
    public int calculateAge(DateOfBirth birth) {

        currentDate = LocalDate.now();

        int currentAge = currentDate.getYear() - birth.getBirthYear();

        if(currentDate.getMonthValue() < birth.getBirthMonth()) { // current month < birth month, i.e. if the birth month has past or not
            currentAge--;
        }
        if(currentDate.getMonthValue() == birth.getBirthMonth() && currentDate.getDayOfMonth() < birth.getBirthDay()) { //If your birth month is current month, check if day has past
            currentAge--;
        }
        return currentAge;
    }

    //Calculates max heart rate with the formula from assignment instructions
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


    //Prints out the data to user with formatting as specified in instructions.
    //Since the calculations needed requires multiple steps, they were combined into one formula rather than storing each step into a variable
    public void printData(PersonHeartRate personToPrint) {

        int personMaxHeartRate = personToPrint.calculateMaxHeartRate(personToPrint.calculateAge(personToPrint.getBirthInfo()));

        System.out.println(personToPrint.getLastName() + ", " + personToPrint.getFirstName()
        + "\n" + personMaxHeartRate + "\n" + personToPrint.calculateTargetHeartRate(personMaxHeartRate) + "\n");

    }

}
