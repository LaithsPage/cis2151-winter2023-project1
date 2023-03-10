package proj1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Proj1
 * Author: Jacob "Laith" Riley
 * Class: CIS 2151
 * Prof: Dr. J
 */
public class HeartRateDemo {


    private static final ArrayList<PersonHeartRate> heartRateList = new ArrayList<>();

    //Main method for HeartRate project
    //Prompts user for information, adds it to the list, uses while loop and user input to run until user prompts it to stop,
    // then will do a foreach loop on the list and print the information to the console. Checking if the user entered the correct type of information could be added in the future
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the heart rate calculator. You will be prompted to enter information in by keyboard, then press enter to move to the next prompt");

        String firstName;
        String lastName;
        int birthMonth;
        int birthDay;
        int birthYear;
        boolean endProgram = false;

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
        for(PersonHeartRate people : heartRateList) {
            people.printData(people);
        }

    }

}
