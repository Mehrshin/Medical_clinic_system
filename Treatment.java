/**
 * Purpose: create the Treatment class
 * 
 * @version 1.0
 * @since 2023-07-13
 * @author Shirin - Megan - Hossein
 */

public class Treatment {
    // data members
    private String treatmentType;
    private Patient treatmentForPatient;
    private Doctor providedByDoctor;
    private MyDate startingDate;
    private int duration;
    private int frequency;
    private String notes;

    // constructor without parameters
    public Treatment() {
        treatmentType = "";
        treatmentForPatient = new Patient();
        providedByDoctor = new Doctor();
        startingDate = new MyDate();
        duration = 0;
        frequency = 0;
        notes = "";
    }

    // constructor with parameters
    public Treatment(String aTreatmentType, Patient aPatient, Doctor aDoctor, MyDate aStartingDate, int aDuration,
            int aFrequency, String aNotes) {
        this.treatmentType = aTreatmentType;
        this.treatmentForPatient = aPatient;
        this.providedByDoctor = aDoctor;
        this.startingDate = aStartingDate;
        this.duration = aDuration;
        this.frequency = aFrequency;
        this.notes = aNotes;
    }

    // mutators
    public void setTreatmentType(String theTreatmentType) {
        this.treatmentType = theTreatmentType;
    }

    public void setTreatmentForPatient(Patient theTreatmentForPatient) {
        this.treatmentForPatient = theTreatmentForPatient;
    }

    public void setProvidedByDoctor(Doctor theProvidedByDoctor) {
        this.providedByDoctor = theProvidedByDoctor;
    }

    public void setStartingDate(MyDate theStartingDate) {
        this.startingDate = theStartingDate;
    }

    public void setDuration(int theDuration) {
        this.duration = theDuration;
    }

    public void setFrequency(int theFrequency) {
        this.frequency = theFrequency;
    }

    public void setNotes(String theNotes) {
        this.notes = theNotes;
    }

    // accessors

    public String getTreatmentType() {
        return this.treatmentType;
    }

    public Patient getTreatmentForPatient() {
        return this.treatmentForPatient;
    }

    public Doctor getProvidedByDoctor() {
        return this.providedByDoctor;
    }

    public MyDate getStartingDate() {
        return this.startingDate;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public String getNotes() {
        return this.notes;
    }

    @Override
    public String toString() {
        return String.format("%nType of treatment: %s%nFor patient: %s, Provided by Doctor: %s%n" +
                "Starting: %s%nFor a duration of %d week(s), with %d visit(s) per week%nNotes: %s%n",
                this.getTreatmentType(), this.getTreatmentForPatient().getFullName(),
                this.getProvidedByDoctor().getFullName(),
                this.getStartingDate(), this.getDuration(), this.getFrequency(), this.getNotes());
    }
}
