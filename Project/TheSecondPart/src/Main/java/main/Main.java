package main;

import Model.*;
import Service.ApplicationService;
import Service.CandidateService;
import Service.FacultyService;
import Service.SpecializationService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void loadExistingData() {

        CandidateService candidateService = CandidateService.getInstance();
        SpecializationService specializationService = SpecializationService.getInstance();
        ApplicationService applicationService = ApplicationService.getInstance();
        FacultyService facultyService = FacultyService.getInstance();

        facultyService.loadFaculties();
        specializationService.loadSpecializations();
        candidateService.loadCandidates();
        applicationService.loadApplications();

    }

    public static void candidateFunctions() {
        CandidateService candidateService = CandidateService.getInstance();

        System.out.println("Welcome! You choose the CANDIDATE class");
        System.out.println("Choose one operation:\n");
        System.out.println("-1. Exit");
        System.out.println("0. Add a new candidate:");
        System.out.println("1. Show all applications candidates: ");
        System.out.println("2. Show all applications candidate for budget:  ");
        System.out.println("3. Show all countryside candidate applications: ");
        System.out.println("4. Show all toll candidates applications:  ");
        System.out.println("5. Modify the name of a candidate: ");
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

                System.out.print("FacultyCode");
                String FacultyCode = in.nextLine();

                System.out.print("Bac - the average");
                double bacResult = in.nextDouble();

                System.out.println("Candidate Type:");
                String candidateType = in.nextLine();

                System.out.println("Choose the type of the candidate: ");
                System.out.println("BudgetCandidate: 1");
                System.out.println("TollCandidate: 2");
                System.out.println("MinorityCandidate: 3");
                System.out.println("CountrysideCandidate: 4");

                int opt = in.nextInt();
                in.nextLine();


                if (opt == 1) {
                    BudgetCandidate bc = new BudgetCandidate(FirstName, LastName, CNP, bacResult, FacultyCode, candidateType);
                    candidateService.addCandidate(bc);
                } else if (opt == 2) {
                    TollCandidate tc = new TollCandidate(FirstName, LastName, CNP, bacResult, FacultyCode, candidateType);
                    candidateService.addCandidate(tc);
                } else if (opt == 3) {
                    MinorityCandidate mc = new MinorityCandidate(FirstName, LastName, CNP, bacResult, FacultyCode, candidateType);
                    candidateService.addCandidate(mc);
                } else {
                    CountrysideCandidate csc = new CountrysideCandidate(FirstName, LastName, CNP, bacResult, FacultyCode, candidateType);
                    candidateService.addCandidate(csc);
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

            case 3: {
                ArrayList<CountrysideCandidate> countrysideCandidates = candidateService.getAllCountrysideCandidates();

                for (CountrysideCandidate c : countrysideCandidates)
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

                candidateService.modifyCandidateNameByCnp(cnp, newName);
                break;
            }

            case 6: {
                System.out.println("Read the cnp:");
                String cnp = in.nextLine();

                try {
                    candidateService.removeCandidateByCnp(cnp);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static void applicationsFunctions() {
        ApplicationService applicationService = ApplicationService.getInstance();

        System.out.println("Welcome! You choose the CANDIDATE-APPLICATION class");
        System.out.println("Choose one operation:\n");
        System.out.println("-1. Exit");
        System.out.println("0. Add a new application:");
        System.out.println("1. Show all applications candidates: ");
        System.out.println("2. Show all applications from a specific faculty:  ");
        System.out.println("3. Delete an application:");

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

                System.out.println("Specialization:");
                String spec = in.nextLine();

                System.out.print("LastName");
                String LastName = in.nextLine();

                System.out.print("FirstName");
                String FirstName = in.nextLine();

                System.out.print("CNP");
                String CNP = in.nextLine();

                System.out.print("FacultyCode");
                String FacultyCode = in.nextLine();

                System.out.print("Bac - the average");
                double bacResult = in.nextDouble();

                System.out.println("Candidate Type:");
                String candidateType = in.nextLine();

                System.out.println("Faculty name:");
                String facultyname = in.nextLine();

                System.out.println("Admission result:");
                double adresult = in.nextDouble();

                System.out.println("Choose the type of the candidate: ");
                System.out.println("BudgetCandidate: 1");
                System.out.println("TollCandidate: 2");
                System.out.println("MinorityCandidate: 3");
                System.out.println("CountrysideCandidate: 4");

                int opt = in.nextInt();
                in.nextLine();

                if (opt == 1) {
                    BudgetCandidate bc = new BudgetCandidate(FirstName, LastName, CNP, bacResult, FacultyCode, candidateType);
                    CandidateApplication a = new CandidateApplication(admission, new Specialization(spec), bc, new Faculty(facultyname), adresult);
                    applicationService.addApplication(a);

                } else if (opt == 2) {
                    TollCandidate tc = new TollCandidate(FirstName, LastName, CNP, bacResult, FacultyCode, candidateType);
                    CandidateApplication a = new CandidateApplication(admission, new Specialization(spec), tc, new Faculty(facultyname), adresult);
                    applicationService.addApplication(a);
                } else if (opt == 3) {
                    MinorityCandidate mc = new MinorityCandidate(FirstName, LastName, CNP, bacResult, FacultyCode, candidateType);
                    CandidateApplication a = new CandidateApplication(admission, new Specialization(spec), mc, new Faculty(facultyname), adresult);
                    applicationService.addApplication(a);
                } else {
                    CountrysideCandidate csc = new CountrysideCandidate(FirstName, LastName, CNP, bacResult, FacultyCode, candidateType);
                    CandidateApplication a = new CandidateApplication(admission, new Specialization(spec), csc, new Faculty(facultyname), adresult);
                    applicationService.addApplication(a);
                }
                break;
            }

            case 1: {
                ArrayList<CandidateApplication> allCandidates = applicationService.getListOfApplications();

                for (CandidateApplication a : allCandidates)
                    System.out.println(a);
                break;
            }

            case 2: {
                System.out.println("Read the name of an existing faculty:");
                String nameFaculty = in.nextLine();

                ArrayList<CandidateApplication> allCandidates = applicationService.getApplicationsFacultyByName(nameFaculty);

                for (CandidateApplication a : allCandidates)
                    System.out.println(a.toString());
                break;
            }

            case 3: {
                System.out.println("Read the cnp for delete the application:");
                String cnp = in.nextLine();
                try {
                    applicationService.removeAppByCnp(cnp);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
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
        System.out.println("1. Show all faculties:");
        System.out.println("2. Print all the informations about a faculty:");

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
                String nameF = in.nextLine();

                System.out.println("Faculty code:");
                String facutyCode = in.nextLine();

                System.out.println("Budget number positions:");
                int b = in.nextInt();

                System.out.println("Toll number positions:");
                int t = in.nextInt();

                System.out.println("Countryside number positions:");
                int cs = in.nextInt();

                System.out.println("Minority number positions:");
                int m = in.nextInt();

                Faculty f = new Faculty(nameF, facutyCode, b, t, cs, m);

                facultyService.add(f);
                break;

            }

            case 1: {
                ArrayList<Faculty> faculties = facultyService.getAllFaculties();

                for (Faculty f : faculties)
                    System.out.println(f);
                break;
            }

            case 2: {
                System.out.println("Read the name faculty you are looking for:");
                String nameFaculty = in.nextLine();
                try {
                    Faculty f = facultyService.findFacultyByName(nameFaculty);
                    System.out.println(f.toString());
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
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
        System.out.println("1. Show all specializations from all faculties:");
        System.out.println("2. Print all the informations about a specialization:");
        System.out.println("3. Show all specializations from a faculty ");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        in.nextLine();

        switch (option) {

            case -1: {

                break;
            }

            case 0: {
                System.out.println("Read data from specialization:");

                System.out.println("Code of specialization:");
                String code = in.nextLine();

                System.out.println("Name of specialization:");
                String nameS = in.nextLine();

                System.out.println("Budget number positions:");
                int b = in.nextInt();

                System.out.println("Toll number positions:");
                int t = in.nextInt();

                System.out.println("Countryside number positions:");
                int cs = in.nextInt();

                System.out.println("Minority number positions:");
                int m = in.nextInt();

                System.out.println("The faculty code that belong this specialization:");
                String facutyCode = in.nextLine();

                Specialization s = new Specialization(code, nameS, b, t, cs, m, facutyCode);
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
                System.out.println("Read the name of specialization you are looking for:");
                String namespe = in.nextLine();
                try {
                    Specialization s = specializationService.getSpecByName(namespe);
                    System.out.println(s.toString());
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                break;
            }

            case 3: {
                System.out.println("Read the code of the faculty:");
                String codeFaculty = in.nextLine();

                ArrayList<Specialization> specializations = specializationService.gelAllFacultySpecializationsByCode(codeFaculty);

                for (Specialization s : specializations)
                    System.out.println(s);
                break;
            }
        }
    }

    public static void main(String[] args) {

        loadExistingData();

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
