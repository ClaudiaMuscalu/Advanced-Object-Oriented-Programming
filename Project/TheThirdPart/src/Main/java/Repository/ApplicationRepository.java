package Repository;

import Model.*;

import java.util.ArrayList;

public class ApplicationRepository {
    private static final int units = 40;
    private int capacity = 20;
    private ArrayList<CandidateApplication> listOfApplications;

    public ApplicationRepository() {
        listOfApplications = new ArrayList<>(capacity);
    }

    public void addApplication(CandidateApplication a) {
        int size = listOfApplications.size();
        int new_capacity = capacity + units;

        if (size == capacity)
            listOfApplications.ensureCapacity(new_capacity);

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

    public ArrayList<CandidateApplication> getApplicationsFacultyByCode(String facultyCode) {
        ArrayList<CandidateApplication> applicationsFaculty = new ArrayList<>();

        for (CandidateApplication a : listOfApplications) {
            if (a.getFacultyCode().equals(facultyCode)) {
                applicationsFaculty.add(a);
            }
        }

        return applicationsFaculty;
    }

    public ArrayList<CandidateApplication> getApplicationsFacultyAndSpecByCodes(String facultyCode,
                                                                         String codeSpec) {
        ArrayList<CandidateApplication> listOfFacultyBySpecialization = new ArrayList<>();

        for (CandidateApplication c : listOfApplications) {
            if (c.getFacultyCode().equals(facultyCode)
                    && c.getCodeSpec().equals(codeSpec)) {
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

    public ArrayList<CandidateApplication> getAllBudgetFacultyAndSpec(String facultyCode,
                                                                      String codeSpec) {
        ArrayList<CandidateApplication> budgetCandidatesApp = this.getAllBudgetCandidatesApp();

        ArrayList<CandidateApplication> budgetAppFacultySpec = new ArrayList<>();

        for (CandidateApplication a : budgetCandidatesApp) {

            if (a.getFacultyCode().equals(facultyCode) &&
                    a.getCodeSpec().equals(codeSpec)) {
                budgetAppFacultySpec.add(a);
            }

        }
        return budgetAppFacultySpec;
    }

    //Toate aplicatiile la taxa
    public ArrayList<CandidateApplication> getAllTollCandidates() {
        ArrayList<CandidateApplication> tollCandidatesApp = new ArrayList<>();

        for (CandidateApplication c : listOfApplications) {
            if (c.getCandidate() instanceof TollCandidate) {
                tollCandidatesApp.add(c);
            }
        }
        return tollCandidatesApp;
    }

    // Toate aplicatiile la taxa de la o anumita facultate
    public ArrayList<CandidateApplication> getAllTollFaculty(String facultyCode) {
        ArrayList<CandidateApplication> tollCandidatesApp = this.getAllTollCandidates();

        ArrayList<CandidateApplication> tollAppFaculty = new ArrayList<>();

        for (CandidateApplication a : tollCandidatesApp) {

            if (a.getFacultyCode().equals(facultyCode)) {
                tollAppFaculty.add(a);
            }

        }
        return tollCandidatesApp;
    }

    // Aplicatiile la taxa de la o facultate cu un anumit cod si o spec
    // cu un anumit cod
    public ArrayList<CandidateApplication> getAllTollFacultyAndSpec(String facultyCode,
                                                                    String codeSpec) {
        ArrayList<CandidateApplication> tollCandidatesApp = this.getAllTollCandidates();
        ArrayList<CandidateApplication> tollAppFacultySpec = new ArrayList<>();

        for (CandidateApplication a :  tollCandidatesApp) {

            if (a.getFacultyCode().equals(facultyCode) &&
                    a.getCodeSpec().equals(codeSpec)) {
                tollCandidatesApp.add(a);
            }

        }

        return tollCandidatesApp;
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
