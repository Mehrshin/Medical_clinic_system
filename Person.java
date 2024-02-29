import java.time.LocalDateTime;

/**
 * Purpose: create the Person class
 * 
 * @version 1.0
 * @since 2023-07-13
 * @author Shirin - Megan - Hossein
 */

// declare class
public abstract class Person {
    // data members
    private String firstName;
    private String lastName;
    private MyDate dateOfBirth;
    private char gender;
    private String address;
    private String phoneNumber;

    // default constructor
    public Person() {
        firstName = "";
        lastName = "";
        dateOfBirth = new MyDate();
        gender = ' ';
        address = "";
        phoneNumber = "";
    }

    // parameterized constructor
    public Person(String aFirstName, String aLastName, MyDate aDate, char aGender, String anAddress,
            String aPhoneNumber) {
        setPersonInfo(aFirstName, aLastName, aDate, aGender, anAddress, aPhoneNumber);
    }

    public void setPersonInfo(String theFirstName, String theLastName, MyDate theDate, char theGender, String theAddress,
            String thePhoneNumber) {
        this.firstName = theFirstName;
        this.lastName = theLastName;
        this.dateOfBirth = theDate;
        this.gender = theGender;
        this.address = theAddress;
        this.phoneNumber = thePhoneNumber;
    }

    // accessors methods
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

    public char getGender() {
        return this.gender;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setFirstName(String aFirstName) {
        this.firstName = aFirstName;
    }

    public void SetLastName(String aLastName) {
        this.lastName = aLastName;
    }

    public void SetGender(char aGender) {
        this.gender = aGender;
    }

    public void setAddress(String anAddress) {
        this.address = anAddress;
    }

    public void setPhoneNumber(String aPhoneNumber) {
        this.phoneNumber = aPhoneNumber;
    }

    /**
     * 
     * @return age based on the birth date
     */
    public int calculateAge() {
        return LocalDateTime.now().getYear() - dateOfBirth.getYear();
    }

    /**
     * 
     * @return person's full name
     */
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public String toString() {
        return getClass().getName() + "\n" + getFirstName() + " " + getLastName() +
                " (" + getGender() + ")" + "\nDate of birth: " + getDateOfBirth() +
                "\nAddress: " + getAddress() + ", Phone Number: " + getPhoneNumber();
    }
}