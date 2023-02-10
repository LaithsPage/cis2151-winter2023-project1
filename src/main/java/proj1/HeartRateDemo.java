package proj1;

import java.util.ArrayList;
import java.util.Scanner;

public class HeartRateDemo {

    //final array so its reference cannot be changed
    private static final ArrayList<PersonHeartRate> heartRateList = new ArrayList<PersonHeartRate>();
    //boolean variable for using while loop, making it static allows to be referenced elsewhere, just in case other methods want to interact while program is running
    private static boolean endProgram = false;

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the heart rate calculator. You will be prompted to enter information in by keyboard, then press enter to move to the next prompt");

        //declaring variables before a loop so they do not get created multiple times
        String firstName;
        String lastName;
        int birthMonth;
        int birthDay;
        int birthYear;

        //While loop will continue until prompted by the user to stop.
        //Keeps asking the user for the necessary information for calculating the heart rate info
        //User input is used to create new object instances and then assigned to an ArrayList
        while(!endProgram) {


            System.out.println("Please enter the person's first name");
            firstName = keyboard.nextLine();
            System.out.println("Please enter the person's last name");
            lastName = keyboard.nextLine();
            System.out.println("Please enter the person's birth month as a number (e.g. born in June = 6, born in October = 10");
            birthMonth = Integer.parseInt(keyboard.nextLine());
            System.out.println("Please enter the person's birthday (i.e. the day they were born on)");
            birthDay = Integer.parseInt(keyboard.nextLine());
            System.out.println("Please enter the person's year of birth");
            birthYear = Integer.parseInt(keyboard.nextLine());

            DateOfBirth userBirthInput = new DateOfBirth(birthMonth, birthDay, birthYear);
            PersonHeartRate userPersonInput = new PersonHeartRate(firstName, lastName, userBirthInput);
            heartRateList.add(userPersonInput);


            System.out.println("Would you like to enter a new person? This program can return the heart rate information for all users entered without overwriting previous entries." +
                    "Please enter 'Y' for 'yes' and 'N' for 'no'");

            String goAgain = keyboard.nextLine();


            if(goAgain.equalsIgnoreCase("n")) {
                endProgram = true;
            }

        }

        //reads through our ArrayList and prints the data out for all people in the ArrayList
        for(PersonHeartRate people : heartRateList) {
            people.printData(people);
        }

    }

}
