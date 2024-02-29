/**
 * Purpose: create the Patient class extends from person
 * 
 * @version 1.0
 * @since 2023-07-13
 * @author Shirin - Megan - Hossein
 */

public class Patient extends Person {
    // data member
    private String patientId;
    private String insuranceCompany;

    // constructor without parameters
    public Patient(){
        super();
        this.patientId = "";
        this.insuranceCompany = "";
    }

    // constructor with parameters
    public Patient(String aFirstName, String aLastName, MyDate aBirthDate, char aGender, String anAddress, String aPhoneNumber, String aPatientId, String anInsuranceCo) {
        super(aFirstName, aLastName, aBirthDate, aGender, anAddress, aPhoneNumber);
        this.patientId = aPatientId;
        this.insuranceCompany = anInsuranceCo;
    }

    public void setPatientId(String thePatientId) {
        this.patientId = thePatientId;
    }

    public void setInsuranceCompany(String theInsuranceCompany) {
        this.insuranceCompany = theInsuranceCompany;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getInsuranceCompany() {
        return this.insuranceCompany;
    }


    @Override
    public String toString() {
        return String.format("%s\nInsurance Company: %s\n", super.toString(),
                this.getInsuranceCompany());
    }
}
