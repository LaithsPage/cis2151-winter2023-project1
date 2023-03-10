package proj1;

/**
 * Proj1
 * Author: Jacob "Laith" Riley
 * Class: CIS 2151
 * Prof: Dr. J
 */
public class DateOfBirth {

    private int birthMonth;
    private int birthDay;
    private int birthYear;


    //Class constructor
    public DateOfBirth(int birthMonth, int birthDay, int birthYear) {
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
