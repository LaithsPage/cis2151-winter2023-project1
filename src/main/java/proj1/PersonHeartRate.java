package proj1;
import java.time.LocalDate;

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

    //Function to calculate age
    //Takes parameter for a DateOfBirth instance
    //Creates new LocalDate instance that is assigned to currentDate reference
    //Uses currentDate to get the current date from user's system clock, and then determines their age
    //Local date class can provide date values as type int
    //Formula for calculating age is (year - birth year) = age. Age is reduced by 1 if birthday has not occured this year
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

        //converting to percentage
        lowEndOfRange = maxHeartRate * 0.50;
        highEndOfRange = maxHeartRate * 0.85;

        heartRateRange = lowEndOfRange + " - " + highEndOfRange;

        return heartRateRange;
    }

    //Will print the name, max heart rate, and target heart rate range of a given PersonHeartRate instance
    //Instantiates variable of type int with the formula to calculate max heart rate
    //Prints out the appropriate information with proper formatting
    public void printData(PersonHeartRate personToPrint) {

        int personMaxHeartRate = personToPrint.calculateMaxHeartRate(personToPrint.calculateAge(personToPrint.getBirthInfo()));

        System.out.println(personToPrint.getLastName() + ", " + personToPrint.getFirstName()
        + "\n" + personMaxHeartRate + "\n" + personToPrint.calculateTargetHeartRate(personMaxHeartRate) + "\n");

    }

}
