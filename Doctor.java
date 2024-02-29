/**
 * Purpose: create the Doctor class extends from person
 * 
 * @version 1.0
 * @since 2023-07-13
 * @author Shirin - Megan - Hossein
 */

public class Doctor extends Person {
    // data member
    private String doctorId;
    private MyDate dateEmployed;
    private String specialty;

    // constructor without parameters
    public Doctor(){
        super();
        dateEmployed = new MyDate();
        specialty = "";
    }


    // constructor with parameters
    public Doctor(String aFirstName, String aLastName, MyDate aDate, char aGender, String anAddress, String aPhoneNumber,
            String aDoctorId, MyDate aDateEmployed, String aSpecialty) {
        super(aFirstName, aLastName, aDate, aGender, anAddress, aPhoneNumber);
        this.doctorId = aDoctorId;
        this.dateEmployed = aDateEmployed;
        this.specialty = aSpecialty;
    }

    /**
     * sets the doctor's Id
     * 
     * @param theDoctorId
     */
    public void setDoctorId(String theDoctorId) {
        this.doctorId = theDoctorId;
    }

    /**
     * sets the doctor's specialty
     * 
     * @param theSpecialty
     */
    public void setSpecialty(String theSpecialty) {
        this.specialty = theSpecialty;
    }

    /**
     * sets the doctor's employed date
     * 
     * @param theDate
     */
    public void setDateEmployed(MyDate theDate) {
        this.dateEmployed = theDate;
    }

    

    /**
     * 
     * @return doctor's ID
     */
    public String getDoctorId() {
        return this.doctorId;
    }

    /**
     * 
     * @return doctor's specialty
     */
    public String getSpecialty() {
        return this.specialty;
    }

    /**
     * @return doctor's employment date
     */
    public MyDate getDateEmployed() {
        return this.dateEmployed;
    }

    // return a string representation of Doctor object
    @Override
    public String toString() {
        return String.format("%s%n%s%s%n%s%s", super.toString(), "Date Employed: ", getDateEmployed(), "Specialty: ",
                getSpecialty());
    }
}
