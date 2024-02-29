
/**
 * Purpose: Medical Clinic System.
 * 
 * @version 1.0
 * @since 2023-07-13
 * @author Shirin - Megan - Hossein
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MedicalClinicSystem {
    private static List<Doctor> doctors; // doctors list
    private static List<Patient> patients; // patients list
    private List<Treatment> treatments; // treatments list
    private static final String DOCTOR_FILE_PATH = "doctor.txt";
    private static final String PATIENT_FILE_PATH = "patient.txt";
    private static final String TREATMENT_FILE_PATH = "treatment.txt";

    // Constructor without parameters
    public MedicalClinicSystem() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        treatments = new ArrayList<>();
        loadDoctorsFromFile();
        loadPatientsFromFile();
        loadTreatmentsFromFile();
    }

    /**
     * Option 1. Add a new doctor
     * Method to register a new doctor information in the patient array and file
     * 
     * @param aFirstName
     * @param aLastName
     * @param aDate
     * @param aGender
     * @param anAddress
     * @param aPhoneNumber
     * @param aDoctorId
     * @param aDateEmployed
     * @param aSpecialty
     */
    public void registerNewDoctor(String aFirstName, String aLastName, MyDate aDate, char aGender, String anAddress,
            String aPhoneNumber,
            String aDoctorId, MyDate aDateEmployed, String aSpecialty) {
        Doctor newDoctor = new Doctor(aFirstName, aLastName, aDate, aGender, anAddress, aPhoneNumber, aDoctorId,
                aDateEmployed, aSpecialty);
        doctors.add(newDoctor);
        saveDoctorToFile(newDoctor);
        System.out.println("Doctor added successfully.");
    }

    /**
     * Option 2. Add a new patient
     * Method to register a new patient information in the patient array and file
     * 
     * @param aFirstName
     * @param aLastName
     * @param aBirthDate
     * @param aGender
     * @param anAddress
     * @param aPhoneNumber
     * @param aPatientId
     * @param anInsuranceCo
     */
    public void registerNewPatient(String aFirstName, String aLastName, MyDate aBirthDate, char aGender,
            String anAddress, String aPhoneNumber, String aPatientId, String anInsuranceCo) {
        Patient newPatient = new Patient(aFirstName, aLastName, aBirthDate, aGender, anAddress, aPhoneNumber,
                aPatientId, anInsuranceCo);
        patients.add(newPatient);
        savePatientToFile(newPatient);
        System.out.println("Patient added successfully.");
    }

    /**
     * Option 3. Record a treatment
     * Method to register a new treatment information in the treatment array and
     * file
     * 
     * @param aTreatmentType
     * @param aPatientFirstName
     * @param aPatientLastName
     * @param aDoctorFirstName
     * @param aDoctorLastName
     * @param aStartingDate
     * @param aDuration
     * @param aFrequency
     * @param aNotes
     */
    public void registerNewTreatment(String aTreatmentType, String aPatientFirstName, String aPatientLastName,
            String aDoctorFirstName, String aDoctorLastName, MyDate aStartingDate, int aDuration,
            int aFrequency, String aNotes) {
        Patient thePatient = findPatientByName(aPatientFirstName, aPatientLastName);
        Doctor theDoctor = findDoctorByName(aDoctorFirstName, aDoctorLastName);

        if (theDoctor != null && thePatient != null) {
            Treatment newTreatment = new Treatment(aTreatmentType, thePatient, theDoctor, aStartingDate, aDuration,
                    aFrequency, aNotes);
            treatments.add(newTreatment);
            saveTreatmentToFile(newTreatment);
            System.out.println("Treatment recorded successfully.");
        } else if (theDoctor == null) {
            System.out.println("Doctor not found.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    /**
     * Option 4. View all doctors
     */
    public void viewDoctors() {
        System.out.println("\n----- Doctors -----\n");
        System.out.printf("| %-10s | %-20s | %-10s | %-20s | %-15s | %n", "Doctor ID", "Doctor Name", "Birthdate",
                "Specialty", "Date Employed");
        System.out.printf(
                "---------------------------------------------------------------------------------------------%n");
        for (Doctor doctor : doctors) {
            System.out.printf("| %-10s | %-20s | %-10s | %-20s | %-15s | %n",
                    doctor.getDoctorId(), doctor.getFullName(), doctor.getDateOfBirth(),
                    doctor.getSpecialty(), doctor.getDateEmployed());
        }
    }

    /**
     * Option 5. View all patients
     */
    public void viewPatients() {
        System.out.println("\n----- Patients -----\n");
        System.out.printf("| %-10s | %-20s | %-10s | %-20s | %n", "Patient ID", "Patient Name", "Birthdate",
                "Insurance Company");
        System.out.printf(
                "---------------------------------------------------------------------------------------------%n");
        for (Patient patient : patients) {
            System.out.printf("| %-10s | %-20s | %-10s | %-20s | %n",
                    patient.getPatientId(), patient.getFullName(), patient.getDateOfBirth(),
                    patient.getInsuranceCompany());
        }
    }

    /**
     * Option 6. View all treatments
     */
    public void viewTreatments() {
        System.out.println("\n----- Treatments -----\n");
        System.out.printf("| %-20s | %-20s | %-15s | %-10s | %-15s | %-20s | %n", "Treatment", "Provided by Doctor",
                "For patient",
                "Start date", "Duration(Weeks)", "Frequency(per week)");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------");
        for (Treatment treatment : treatments) {
            System.out.printf("| %-20s | %-20s | %-15s | %-10s | %15s | %20s | %n", treatment.getTreatmentType(),
                    treatment.getProvidedByDoctor().getFullName(), treatment.getTreatmentForPatient().getFullName(),
                    treatment.getStartingDate(), treatment.getDuration(), treatment.getFrequency());
        }
    }

    /**
     * Option 7. View treatments by a doctor (an overloading of the method
     * viewTreatments)
     * 
     * @param theDoctor
     */
    public void viewTreatments(Doctor theDoctor) {
        if (theDoctor != null) {
            ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
            for (Treatment treatment : treatments) {
                if (treatment.getProvidedByDoctor().getFirstName().equalsIgnoreCase(theDoctor.getFirstName())
                        && treatment.getProvidedByDoctor().getLastName().equalsIgnoreCase(theDoctor.getLastName())) {
                    treatmentList.add(treatment);
                }
            }
            System.out.println();
            System.out.printf("| %-20s | %-20s | %-15s | %-10s | %-15s | %-20s | %n", "Treatment", "Provided by Doctor",
                    "For patient",
                    "Start date", "Duration(Weeks)", "Frequency(per week)");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------");

            for (Treatment treatment : treatmentList) {
                System.out.printf("| %-20s | %-20s | %-15s | %-10s | %15s | %20s | %n",
                        treatment.getTreatmentType(),
                        treatment.getProvidedByDoctor().getFullName(),
                        treatment.getTreatmentForPatient().getFullName(),
                        treatment.getStartingDate(), treatment.getDuration(), treatment.getFrequency());
            }
        } else {
            System.out.println();
            System.out.printf("-----------No such a doctor found.------------");
            System.out.println();
        }
    }

    /**
     * Option 8. View treatments of a patient (an overloading of the method
     * viewTreatments)
     * 
     * @param thePatient
     */
    public void viewTreatments(Patient thePatient) {
        if (thePatient != null) {
            ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
            for (Treatment treatment : treatments) {
                if (treatment.getTreatmentForPatient().getFirstName().equalsIgnoreCase(thePatient.getFirstName())
                        && treatment.getTreatmentForPatient().getLastName()
                                .equalsIgnoreCase(thePatient.getLastName())) {
                    treatmentList.add(treatment);
                }
            }
            System.out.println();
            System.out.printf("| %-20s | %-20s | %-15s | %-10s | %-15s | %-20s | %n", "Treatment", "Provided by Doctor",
                    "For patient",
                    "Start date", "Duration(Weeks)", "Frequency(per week)");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------");

            for (Treatment treatment : treatmentList) {
                System.out.printf("| %-20s | %-20s | %-15s | %-10s | %15s | %20s | %n",
                        treatment.getTreatmentType(),
                        treatment.getProvidedByDoctor().getFullName(),
                        treatment.getTreatmentForPatient().getFullName(),
                        treatment.getStartingDate(), treatment.getDuration(), treatment.getFrequency());
            }
        } else {
            System.out.println();
            System.out.printf("------------No such a patient found.-------------");
            System.out.println();
        }
    }

    /**
     * Option 9: method to find a patient by phoneNumber
     * 
     * @param phoneNumber
     */
    public void findPatientByPhoneNumber(String phoneNumber) {
        for (Patient patient : patients) {
            if (patient.getPhoneNumber().trim().equalsIgnoreCase(phoneNumber.trim())) {
                System.out.println("\n----------Found a Record----------\n");
                System.out.println(patient);
                return;
            }
        }
        System.out.println("\n-----------No matching patient------------\n");
    }

    /**
     * Method to read the doctors from text file and add them to doctors array
     */
    public void loadDoctorsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DOCTOR_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String firstName = data[0];
                String lastName = data[1];
                MyDate dateOfBirth = MyDate.changeStringToMyDate(data[2]);
                String gender = data[3];
                String address = data[4];
                String phoneNumber = data[5];
                String drId = data[6];
                MyDate dateEmployed = MyDate.changeStringToMyDate(data[7]);
                String specialty = data[8];
                Doctor doctor = new Doctor(firstName, lastName, dateOfBirth, gender.charAt(0), address, phoneNumber,
                        drId, dateEmployed, specialty);
                doctors.add(doctor);
            }
        } catch (IOException e) {
            System.out.println("Error loading doctors from file: " + e.getMessage());
        }
    }

    /**
     * Method to read the patients from text file and add them to doctors array
     */
    private void loadPatientsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENT_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String firstName = data[0];
                String lastName = data[1];
                MyDate dateOfBirth = MyDate.changeStringToMyDate(data[2]);
                String gender = data[3];
                String address = data[4];
                String phoneNumber = data[5];
                String pId = data[6];
                String insuranceCompany = data[7];
                Patient patient = new Patient(firstName, lastName, dateOfBirth, gender.charAt(0), address, phoneNumber,
                        pId, insuranceCompany);
                patients.add(patient);
            }
        } catch (IOException e) {
            System.out.println("Error loading patients from file: " + e.getMessage());
        }
    }

    /**
     * Method to read the treatments from text file and add them to treatments array
     */
    private void loadTreatmentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TREATMENT_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String treatmentType = data[0];
                String patientFirstName = data[1];
                String patientLastName = data[2];
                String doctorFirstName = data[3];
                String doctorLastName = data[4];
                String stringDate = data[5];
                int duration = Integer.valueOf(data[6]);
                int frequency = Integer.valueOf(data[7]);
                String notes = data[8];

                Doctor doctor = findDoctorByName(doctorFirstName, doctorLastName);
                Patient patient = findPatientByName(patientFirstName, patientLastName);
                if (doctor != null && patient != null) {
                    Treatment treatment = new Treatment(treatmentType, patient, doctor,
                            MyDate.changeStringToMyDate(stringDate), duration,
                            frequency, notes);
                    treatments.add(treatment);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading treatments from file: " + e.getMessage());
        }
    }

    /**
     * Method to add a doctor information entry to the text file doctor in a line
     * 
     * @param newDoctor
     */
    public void saveDoctorToFile(Doctor newDoctor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOCTOR_FILE_PATH, true))) {
            String line = newDoctor.getFirstName() + "," + newDoctor.getLastName() + "," +
                    newDoctor.getDateOfBirth() + "," + newDoctor.getGender() + "," +
                    newDoctor.getAddress() + "," + newDoctor.getPhoneNumber() + "," + newDoctor.getDoctorId() + ","
                    + newDoctor.getDateEmployed() + "," + newDoctor.getSpecialty();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving doctor to file: " + e.getMessage());
        }
    }

    /**
     * Method to add a patient information entry to the text file patient in a line
     * 
     * @param newPatient
     */
    public void savePatientToFile(Patient newPatient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENT_FILE_PATH, true))) {
            String line = newPatient.getFirstName() + "," + newPatient.getLastName() + "," +
                    newPatient.getDateOfBirth() + "," + newPatient.getGender() + "," + newPatient.getAddress() + "," +
                    newPatient.getPhoneNumber() + "," + newPatient.getPatientId() + ","
                    + newPatient.getInsuranceCompany();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving patient to file: " + e.getMessage());
        }
    }

    /**
     * Method to add a treatment information entry to the text file treatment in a
     * line
     * 
     * @param newTreatment
     */
    public void saveTreatmentToFile(Treatment newTreatment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TREATMENT_FILE_PATH, true))) {
            String line = newTreatment.getTreatmentType() + "," + newTreatment.getTreatmentForPatient().getFirstName()
                    + "," + newTreatment.getTreatmentForPatient().getLastName() + ","
                    + newTreatment.getProvidedByDoctor().getFirstName() + ","
                    + newTreatment.getProvidedByDoctor().getLastName() + "," + newTreatment.getStartingDate() + "," +
                    newTreatment.getDuration() + "," + newTreatment.getFrequency() + "," + newTreatment.getNotes();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving treatment to file: " + e.getMessage());
        }
    }

    /**
     * method to find the doctor object by the firstname and lastname
     * 
     * @param firstName
     * @param lastName
     * @return the doctor object
     */
    public Doctor findDoctorByName(String firstName, String lastName) {
        for (Doctor doctor : doctors) {
            if (doctor.getFirstName().trim().equalsIgnoreCase(firstName.trim())
                    && doctor.getLastName().trim().equalsIgnoreCase(lastName.trim())) {
                return doctor;
            }
        }
        return null;
    }

    /**
     * method to find the patient object by the firstname and lastname
     * 
     * @param firstName
     * @param lastName
     * @return the patient object
     */
    public Patient findPatientByName(String firstName, String lastName) {
        for (Patient patient : patients) {
            if (patient.getFirstName().trim().equalsIgnoreCase(firstName.trim())
                    && patient.getLastName().trim().equalsIgnoreCase(lastName.trim())) {
                return patient;
            }
        }
        return null;
    }

}
