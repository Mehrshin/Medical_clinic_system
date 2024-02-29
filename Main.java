
/**
 * Purpose: Main Class.
 * 
 * @version 1.0
 * @since 2023-07-13
 * @author Shirin - Megan - Hossein
 */

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Random rand = new Random();
        int max = 9999, min = 1000;
        int randNumber = rand.nextInt(max - min + 1) + min;

        MedicalClinicSystem MedicalSystem = new MedicalClinicSystem();

        try ( Scanner console = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nWelcome to the NSN Medical Clinic application. Please make a selection:");
                System.out.println("(1) Register a new doctor");
                System.out.println("(2) Register a new patient");
                System.out.println("(3) Create a new treatment plan");
                System.out.println("(4) Display all registered doctors");
                System.out.println("(5) Display all registered patients");
                System.out.println("(6) Display all treatment files");
                System.out.println("(7) Display a doctor's treatment list");
                System.out.println("(8) Display a patient's treatment list");
                System.out.println("(9) Find a patient by phone number");
                System.out.println("(0) Exit");

                int option = console.nextInt();
                console.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Enter doctor's first name:");
                        String doctorFirstName = console.nextLine();
                        System.out.println("Enter doctor's last name:");
                        String doctorLastName = console.nextLine();
                        System.out.println("Enter doctor's date of birth:(dd-mm-yyyy)");
                        String doctorDOB = console.nextLine();
                        MyDate doctorBirthDate = MyDate.changeStringToMyDate(doctorDOB);
                        System.out.println("Enter doctor's gender: (M/F/X)");
                        String dGender = console.nextLine();
                        char doctorGender = dGender.charAt(0);
                        System.out.println("Enter doctor's address:");
                        String doctorAddress = console.nextLine();
                        System.out.println("Enter doctor's phone number:");
                        String doctorPhoneNumber = console.nextLine();
                        System.out.println("Enter doctor's specialty:");
                        String specialty = console.nextLine();
                        System.out.println("Enter doctor's date employed:(dd-mm-yyyy)");
                        String dateEmployed = console.nextLine();
                        MyDate doctorDateEmployed = MyDate.changeStringToMyDate(dateEmployed);
                        String doctorID = "Dr" + String.valueOf(randNumber);
                        MedicalSystem.registerNewDoctor(doctorFirstName, doctorLastName, doctorBirthDate, doctorGender,
                                doctorAddress,
                                doctorPhoneNumber, doctorID, doctorDateEmployed, specialty);
                        break;
                    case 2:
                        System.out.println("Enter Patient's first name:");
                        String patientFirstName = console.nextLine();
                        System.out.println("Enter Patient's last name:");
                        String patientLastName = console.nextLine();
                        System.out.println("Enter Patient's date of birth:(dd-mm-yyyy)");
                        String patientDOB = console.nextLine();
                        MyDate PatientBirthDate = MyDate.changeStringToMyDate(patientDOB);
                        System.out.println("Enter Patient's gender: (M/F/X)");
                        String pGender = console.nextLine();
                        char patientGender = pGender.charAt(0);
                        System.out.println("Enter Patient's address:");
                        String patientAddress = console.nextLine();
                        System.out.println("Enter patient's phone number:");
                        String patientPhoneNumber = console.nextLine();
                        String patientID = "Pt" + String.valueOf(randNumber);
                        System.out.println("Enter patient's insurance company:");
                        String insuranceCompany = console.nextLine();
                        MedicalSystem.registerNewPatient(patientFirstName, patientLastName, PatientBirthDate,
                                patientGender,
                                patientAddress, patientPhoneNumber, patientID, insuranceCompany);
                        break;
                    case 3:
                        System.out.println("Enter treatment Type:");
                        String treatmentType = console.nextLine();
                        System.out.println("Enter patient's first name for the treatment:");
                        String treatedPatientFirstName = console.nextLine();
                        System.out.println("Enter patient's last name for the treatment:");
                        String treatedPatientLastName = console.nextLine();
                        System.out.println("Enter doctor's first name for the treatment:");
                        String treatingDoctorFirstName = console.nextLine();
                        System.out.println("Enter doctor's last name for the treatment:");
                        String treatingDoctorLastName = console.nextLine();
                        System.out.println("Enter treatment start time: (dd-mm-yyyy)");
                        String startTime = console.nextLine();
                        MyDate startingDate = MyDate.changeStringToMyDate(startTime);
                        System.out.println("Enter treatment duration in weeks:");
                        String duration = console.nextLine();
                        System.out.println("Enter treatment frequency per week:");
                        String frequency = console.nextLine();
                        System.out.println("Enter treatment notes:");
                        String notes = console.nextLine();
                        MedicalSystem.registerNewTreatment(treatmentType, treatedPatientFirstName,
                                treatedPatientLastName,
                                treatingDoctorFirstName, treatingDoctorLastName, startingDate,
                                Integer.valueOf(duration),
                                Integer.valueOf(frequency), notes);
                        break;
                    case 4:
                        MedicalSystem.viewDoctors();
                        break;
                    case 5:
                        MedicalSystem.viewPatients();
                        break;
                    case 6:
                        MedicalSystem.viewTreatments();
                        break;
                    case 7:
                        System.out.println("Enter doctor's first name: ");
                        String drFirstName = console.nextLine();
                        System.out.println("Enter doctor's last name: ");
                        String drLasttName = console.nextLine();
                        MedicalSystem.viewTreatments(MedicalSystem.findDoctorByName(drFirstName, drLasttName));
                        break;
                    case 8:
                        System.out.println("Enter patient's first name: ");
                        String pFirstName = console.nextLine();
                        System.out.println("Enter patient's last name: ");
                        String pLasttName = console.nextLine();
                        MedicalSystem.viewTreatments(MedicalSystem.findPatientByName(pFirstName, pLasttName));
                        break;
                    case 9:
                        System.out.println("Enter patient's phone number: ");
                        String pPhoneNumber = console.nextLine();
                        MedicalSystem.findPatientByPhoneNumber(pPhoneNumber);
                        break;
                    case 0:
                        System.out.println("Exiting the Medical Clinic System");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}
