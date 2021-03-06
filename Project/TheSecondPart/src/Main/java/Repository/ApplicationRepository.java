package Repository;

import Model.*;

import java.util.ArrayList;

public class ApplicationRepository {
    private ArrayList<CandidateApplication> listOfApplications = new ArrayList<>();

    public ApplicationRepository({
    }

    public void addApplication(CandidateApplication a) {
        listOfApplications.add(a);
    }

    public void addAdmissionExamCandidate(CandidateApplication c) {
        CandidateApplication x = null;
        for (CandidateApplication a : listOfApplications) {
            if (a.getCandidate().getCnp().equals(c.getCandidate().getCnp())) {
                x = a;
            }
        }
        if (x == null) {
            throw new NullPointerException("This application doesn't exist!");
        }

        c.setResult();
    }

    public CandidateApplication getApplicationByName(String FirstName,
                                                     String LastName) {
        for (CandidateApplication a : listOfApplications) {
            if (a.getCandidate().getLastName().equals(LastName) &&
                    a.getCandidate().getFirstName().equals(FirstName)) {
                return a;
            }
        }
        return null;
    }

    public CandidateApplication getApplicationByCnp(String Cnp) {
        for (CandidateApplication a : listOfApplications) {
            if (a.getCandidate().getCnp().equals(Cnp)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<CandidateApplication> getApplicationsFacultyByName(String nameFaculty) {
        ArrayList<CandidateApplication> applicationsFaculty = new ArrayList<>();

        for (CandidateApplication a : listOfApplications) {
            if (a.getFaculty().getName().equals(nameFaculty)) {
                applicationsFaculty.add(a);
            }
        }

        return applicationsFaculty;
    }

    public ArrayList<CandidateApplication> getApplicationsFacultyAndSpec(String nameFaculty,
                                                                         String nameSpecialization) {
        ArrayList<CandidateApplication> listOfFacultyBySpecialization = new ArrayList<>();

        for (CandidateApplication c : listOfApplications) {
            if (c.getFaculty().getName().equals(nameFaculty)
                    && c.getSpecialization().getNameS().equals(nameSpecialization)) {
                listOfFacultyBySpecialization.add(c);
            }
        }

        return listOfFacultyBySpecialization;
    }

    public ArrayList<CandidateApplication> getAllBudgetCandidatesApp() {
        ArrayList<CandidateApplication> budgetCandidatesApp = new ArrayList<>();

        for (CandidateApplication c : listOfApplications) {
            if (c.getCandidate() instanceof BudgetCandidate) {
                budgetCandidatesApp.add(c);
            }
        }

        return budgetCandidatesApp;
    }

    public ArrayList<CandidateApplication> getAllBudgetFacultyAndSpec(String nameFaculty,
                                                                      String nameSpec) {
        ArrayList<CandidateApplication> budgetCandidatesApp = this.getAllBudgetCandidatesApp();
        ArrayList<CandidateApplication> budgetAppFacultySpec = new ArrayList<>();
        for (CandidateApplication a : budgetCandidatesApp) {
            Specialization s = a.getSpecialization();
            Faculty f = a.getFaculty();
            if (f.getName().equals(nameFaculty) &&
                    s.getNameS().equals(nameSpec)) {
                budgetAppFacultySpec.add(a);
            }

        }
        return budgetAppFacultySpec;
    }


    public ArrayList<CandidateApplication> getAllCountrysideCandidatesApp() {
        ArrayList<CandidateApplication> countrysideCandidatesApp = new ArrayList<>();

        for (CandidateApplication c : listOfApplications) {
            if (c.getCandidate() instanceof CountrysideCandidate) {
                countrysideCandidatesApp.add(c);
            }
        }

        return countrysideCandidatesApp;
    }

    public ArrayList<CandidateApplication> getAllCountrysideFacultyAndSpec(String nameFaculty,
                                                                           String nameSpec) {
        ArrayList<CandidateApplication> countrysideCandidatesApp = this.getAllCountrysideCandidatesApp();
        ArrayList<CandidateApplication> countrysideAppFacultySpec = new ArrayList<>();

        for (CandidateApplication a : countrysideCandidatesApp) {
            Specialization s = a.getSpecialization();
            Faculty f = a.getFaculty();
            if (f.getName().equals(nameFaculty) &&
                    s.getNameS().equals(nameSpec)) {
                countrysideAppFacultySpec.add(a);
            }

        }
        return countrysideAppFacultySpec;
    }

    public ArrayList<CandidateApplication> getAllMinorityCandidatesApp() {

        ArrayList<CandidateApplication> minorityCandidatesApp = new ArrayList<>();

        for (CandidateApplication c : listOfApplications) {
            if (c.getCandidate() instanceof MinorityCandidate) {
                minorityCandidatesApp.add(c);
            }
        }
        return minorityCandidatesApp;
    }

    public ArrayList<CandidateApplication> getAllMinorityFacultyAndSpec(String nameFaculty,
                                                                        String nameSpec) {
        ArrayList<CandidateApplication> minorityCandidatesApp = this.getAllMinorityCandidatesApp();
        ArrayList<CandidateApplication> minorityAppFacultySpec = new ArrayList<>();
        for (CandidateApplication a : minorityCandidatesApp) {
            Specialization s = a.getSpecialization();
            Faculty f = a.getFaculty();
            if (f.getName().equals(nameFaculty) &&
                    s.getNameS().equals(nameSpec)) {
                minorityAppFacultySpec.add(a);
            }

        }
        return minorityAppFacultySpec;
    }

    public ArrayList<CandidateApplication> getAllTollCandidates() {
        ArrayList<CandidateApplication> tollCandidatesApp = new ArrayList<>();

        for (CandidateApplication c : listOfApplications) {
            if (c.getCandidate() instanceof TollCandidate) {
                tollCandidatesApp.add(c);
            }
        }
        return tollCandidatesApp;
    }

    public ArrayList<CandidateApplication> getAllTollFacultyAndSpec(String nameFaculty,
                                                                    String nameSpec) {
        ArrayList<CandidateApplication> tollCandidatesApp = this.getAllTollCandidates();
        ArrayList<CandidateApplication> tollAppFacultySpec = new ArrayList<>();
        for (CandidateApplication a : tollCandidatesApp) {
            Specialization s = a.getSpecialization();
            Faculty f = a.getFaculty();
            if (f.getName().equals(nameFaculty) &&
                    s.getNameS().equals(nameSpec)) {
                tollAppFacultySpec.add(a);
            }

        }
        return tollAppFacultySpec;
    }

    public ArrayList<CandidateApplication> getListOfApplications() {
        return listOfApplications;
    }

    public void removeAppByCnp(String Cnp) {
        CandidateApplication c = null;
        for (CandidateApplication a : listOfApplications) {
            if (a.getCandidate().getCnp().equals(Cnp)) {
                c = a;
            }
        }
        if (c == null) {
            throw new NullPointerException("The candidate with this CNP doesn't exist!");
        }

        listOfApplications.remove(c);
    }
}
