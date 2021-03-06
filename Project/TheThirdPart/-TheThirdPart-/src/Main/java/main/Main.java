package main;

import Model.*;
import Service.ApplicationService;
import Service.CandidateService;
import Service.FacultyService;
import Service.SpecializationService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void candidateFunctions() {
        CandidateService candidateService = CandidateService.getInstance();

        System.out.println("Welcome! You choose the CANDIDATE class");
        System.out.println("Choose one operation:\n");
        System.out.println("-1. Exit");
        System.out.println("0. Add a new candidate:");
        System.out.println("1. Show all candidates: ");
        System.out.println("2. Show all candidate for budget:  ");
        System.out.println("3. Get a candidate by cnp");
        System.out.println("4. Show all candidates for toll:  ");
        System.out.println("5. Update the name of a candidate: ");
        System.out.println("6. Delete a candidate by cnp: ");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        in.nextLine();

        switch (option) {

            case -1: {

                break;
            }

            case 0: {

                System.out.println("Reading data from a candidate:");

                System.out.print("LastName");
                String LastName = in.nextLine();

                System.out.print("FirstName");
                String FirstName = in.nextLine();

                System.out.print("CNP");
                String CNP = in.nextLine();

                System.out.print("CandidateType");
                String candidateType = in.nextLine();

                System.out.print("Bac - the average");
                double bacResult = in.nextDouble();

                System.out.println("Choose the type of the candidate: ");
                System.out.println("BudgetCandidate: 1");
                System.out.println("TollCandidate: 2");

                int opt = in.nextInt();
                in.nextLine();

                if (opt == 1) {
                    BudgetCandidate bc = new BudgetCandidate(CNP,candidateType, FirstName, LastName,  bacResult);
                    candidateService.addCandidate(bc);
                } else if (opt == 2) {
                    TollCandidate tc = new TollCandidate(CNP,candidateType, FirstName, LastName,  bacResult);
                    candidateService.addCandidate(tc);
                }

                break;
            }

            case 1: {
                ArrayList<Candidate> allCandidates = candidateService.getAllCandidates();
                for (Candidate c : allCandidates)
                    System.out.println(c.toString());
                break;
            }

            case 2: {
                ArrayList<BudgetCandidate> budgetCandidates = candidateService.getAllBudgetCandidates();

                for (BudgetCandidate b : budgetCandidates)
                    System.out.println(b.toString());
                break;
            }

            case 3:{

                System.out.println("Read the cnp:");
                String cnp = in.nextLine();

                Candidate c = candidateService.getCandidate(cnp);
                System.out.println(c.toString());
                break;
            }

            case 4: {
                ArrayList<TollCandidate> tollCandidates = candidateService.getAllTollCandidates();

                for (TollCandidate t : tollCandidates)
                    System.out.println(t.toString());
                break;
            }

            case 5: {
                System.out.println("Read the cnp:");
                String cnp = in.nextLine();
                System.out.println("Read the new name:");
                String newName = in.nextLine();

                candidateService.updateLastName(cnp, newName);
                break;
            }

            case 6: {
                System.out.println("Read the cnp:");
                String cnp = in.nextLine();

                try {
                    candidateService.deleteCandidate(cnp);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static void applicationsFunctions() {
        CandidateService candidateService = CandidateService.getInstance();
        ApplicationService applicationService = ApplicationService.getInstance();

        System.out.println("Welcome! You choose the CANDIDATE-APPLICATION class");
        System.out.println("Choose one operation:\n");
        System.out.println("-1. Exit");
        System.out.println("0. Add a new application:");
        System.out.println("1. Show all applications candidates: ");
        System.out.println("2. Show all applications from a specific faculty:");
        System.out.println("3. Update the result from an application:");
        System.out.println("4. Delete an application:");
        System.out.println("5. Get all budget applications from a specific specialization:");
        System.out.println("6. Get all toll applications from a specific specialization:");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        in.nextLine();

        switch (option) {

            case -1: {

                break;
            }

            case 0: {

                System.out.println("Reading data from an application:");

                System.out.println("Admission option: true or false?");
                String admission = in.nextLine();

                System.out.print("CNP");
                String CNP = in.nextLine();

                System.out.println("Faculty code:");
                String facultyCode = in.nextLine();

                System.out.println("Code spec:");
                String codeSpec = in.nextLine();

                System.out.println("Admission result:");
                double result_admission = in.nextDouble();

                Candidate candidate = candidateService.getCandidate(CNP);

                CandidateApplication a = new CandidateApplication(codeSpec, facultyCode, candidate, admission, result_admission);

                applicationService.addApplication(a);

                break;
            }

            case 1: {
                ArrayList<CandidateApplication> allCandidates = applicationService.getAllAplications();

                for (CandidateApplication a : allCandidates)
                    System.out.println(a);
                break;
            }

            case 2: {
                System.out.println("Read the code from faculty:");
                String faculty_code = in.nextLine();
                 ArrayList<CandidateApplication> listApp = applicationService.getAllAplicationsFaculty(faculty_code);

                 for(CandidateApplication c: listApp)
                     System.out.println(c.toString());
                 break;
            }

            case 3: {
                System.out.println("Read the code from the app that you want to update:");
                String app_code = in.nextLine();

                applicationService.updateResult(app_code);
                break;
            }

            case 4: {
                System.out.println("Read the code from the app that you want to delete:");

                String app_code = in.nextLine();
                applicationService.deleteApplication(app_code);

                break;
            }

            case 5: {
                System.out.println("Read the faculty:");
                String facultyCode = in.nextLine();

                System.out.println("Read the specialization:");
                String code_spec = in.nextLine();

                ArrayList<CandidateApplication> applications = applicationService.getAllAplicationsFacultyBudget(facultyCode, code_spec);
                break;
            }

            case 6: {
                System.out.println("Read the faculty:");
                String facultyCode = in.nextLine();

                System.out.println("Read the specialization:");
                String code_spec = in.nextLine();

                ArrayList<CandidateApplication> applications = applicationService.getAllAplicationsFacultyToll(facultyCode, code_spec);
                break;
            }
        }
    }

    public static void facultyFunctions() {
        FacultyService facultyService = FacultyService.getInstance();

        System.out.println("Welcome! You choose the FACULTY class");
        System.out.println("Choose one operation:\n");
        System.out.println("-1. Exit");
        System.out.println("0. Add a new faculty:");
        System.out.println("1. Show all faculties: ");
        System.out.println("2. Get a faculty by code:  ");
        System.out.println("3. Update the name of a faculty: ");
        System.out.println("4. Delete a faculty by code: ");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        in.nextLine();

        switch (option) {
            case -1: {
                break;
            }

            case 0: {
                System.out.println("Read data from faculty:");

                System.out.println("Faculty name:");
                String name = in.nextLine();

                System.out.println("Budget number positions:");
                int b = in.nextInt();

                System.out.println("Toll number positions:");
                int t = in.nextInt();

                Faculty f = new Faculty(name, b, t);

                facultyService.addFaculty(f);
                break;
            }

            case 1: {
                ArrayList<Faculty> faculties = facultyService.getAllFaculties();

                for (Faculty f : faculties)
                    System.out.println(f);
                break;
            }
            case 2:
            {
                System.out.println("Read the Faculty code:");
                String codeFaculty = in.nextLine();
                Faculty f = facultyService.getFaculty(codeFaculty);
                System.out.println(f.toString());
                break;
            }

            case 3: {
                System.out.println("Read the Faculty code: ");
                String facultyCode = in.nextLine();
                System.out.println("Read the new name of a faculty:");
                String name = in.nextLine();

                facultyService.updateFacultyName(facultyCode, name);
                break;
            }

            case 4:
            {
                System.out.println("Read the faculty code:");
                String facultyCode = in.nextLine();
                facultyService.deleteFaculty(facultyCode);
                break;
            }
        }
    }

    public static void specializationsFunctions() {
        SpecializationService specializationService = SpecializationService.getInstance();

        System.out.println("Welcome! You choose the SPECIALIZATION class");
        System.out.println("Choose one operation:\n");
        System.out.println("-1. Exit");
        System.out.println("0. Add a new specialization:");
        System.out.println("1. Show all specializations: ");
        System.out.println("2. Get a specialization by code:  ");
        System.out.println("3. Update the name of a specialization: ");
        System.out.println("4. Delete a specialization by code: ");
        System.out.println("5. Show all specializations from a faculty ");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        in.nextLine();

        switch (option) {

            case -1: {
                break;
            }

            case 0: {
                System.out.println("Read data from specialization:");

                System.out.println("Name of specialization:");
                String nameS = in.nextLine();

                System.out.println("Budget number positions:");
                int b = in.nextInt();

                System.out.println("Toll number positions:");
                int t = in.nextInt();

                in.nextLine();

                System.out.println("The faculty code that belong this specialization:");
                String facutyCode = in.nextLine();

                Specialization s = new Specialization(facutyCode, nameS, b, t);
                specializationService.addSpecialization(s);
                break;
            }

            case 1: {
                ArrayList<Specialization> specializations = specializationService.getAllSpecializations();

                for (Specialization s : specializations)
                    System.out.println(s);
                break;

            }

            case 2: {
                System.out.println("Read the code of specialization you are looking for:");
                String codeS = in.nextLine();
                try {
                    Specialization s = specializationService.getSpecialization(codeS);
                    System.out.println(s.toString());
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                break;
            }

            case 3: {
                System.out.println("Read the code from specialization");
                String codeS = in.nextLine();
                System.out.println("Read the new name from specialization:");
                String newName = in.nextLine();

                specializationService.updateSpecializationName(codeS, newName);
                break;
            }
            case 4: {
                System.out.println("Read the code from specialization");
                String codeS = in.nextLine();

                specializationService.deleteSpecialization(codeS);
                break;
            }

            case 5:
            {
                System.out.println("Read the code from the faculty:");
                String codeFaculty = in.nextLine();

                ArrayList<Specialization> specializations = specializationService.getAllSpecializationsFromFaculty(codeFaculty);

                for(Specialization s : specializations)
                    System.out.println(s.toString());
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("Choose the option for the class :");
            System.out.println("0. Exit");
            System.out.println("1. Candidate");
            System.out.println("2. CandidateApplication");
            System.out.println("3. Faculty");
            System.out.println("4. Specialization");

            option = in.nextInt();
            in.nextLine();

            switch (option) {

                case 0: {
                    break;
                }

                case 1: {
                    candidateFunctions();
                    break;
                }

                case 2: {
                    applicationsFunctions();
                    break;
                }

                case 3: {
                    facultyFunctions();
                    break;
                }

                case 4: {
                    specializationsFunctions();
                    break;
                }
            }
        } while (option != 0);
    }
}
