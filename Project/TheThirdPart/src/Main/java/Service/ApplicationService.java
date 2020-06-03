package Service;

import Model.CandidateApplication;
import Repository.ApplicationRepository;

import java.util.ArrayList;

public class ApplicationService {
    private static ApplicationService instance = null;
    private ApplicationRepository applicationRepository = new ApplicationRepository();

    private ApplicationService() {
    }

    public static ApplicationService getInstance() {
        if (instance == null) {
            instance = new ApplicationService();
        }
        return instance;
    }

    public void addApplication(CandidateApplication a) {
        //auditService.printAction("Add an application", auditService.getTimestamp_action());

        applicationRepository.addApplication(a);

    }

    public CandidateApplication getApplicationByName(String FirstName, String LastName) {
        //auditService.printAction("Get an application by name", auditService.getTimestamp_action());

        CandidateApplication application = applicationRepository.getApplicationByName(FirstName, LastName);

        if (application == null) {
            throw new NullPointerException("The application for this name doesn't exist!");
        }
        return application;
    }

    public ArrayList<CandidateApplication> getApplicationsFacultyByName(String facultyCode) {
        //auditService.printAction("Get applications by faculty name", auditService.getTimestamp_action());

        return applicationRepository.getApplicationsFacultyByCode(facultyCode);
    }

    public ArrayList<CandidateApplication> getApplicationsFacultyAndSpec(String facultyCode,
                                                                         String codeSpec ){
        //auditService.printAction("Get an application by faculty name and specialization", auditService.getTimestamp_action());
        return applicationRepository.getApplicationsFacultyAndSpecByCodes(facultyCode, codeSpec);
    }

    public ArrayList<CandidateApplication> getListOfApplications() {
        //auditService.printAction("Get all the applications", auditService.getTimestamp_action());
        return applicationRepository.getListOfApplications();
    }

    public ArrayList<CandidateApplication> getAllBudgetCandidatesApp() {
        //auditService.printAction("Get all the applications for the budget", auditService.getTimestamp_action());
        return applicationRepository.getAllBudgetCandidatesApp();
    }

    public ArrayList<CandidateApplication> getAllTollCandidates() {
        //auditService.printAction("Get all the applications for toll", auditService.getTimestamp_action());
        return applicationRepository.getAllTollCandidates();
    }

    public ArrayList<CandidateApplication> getAllBudgetFacultyAndSpec(String nameFaculty,
                                                                      String nameSpec) {
        //auditService.printAction("Get all the applications for the budget from a specific specialization and faculty", auditService.getTimestamp_action());
        return applicationRepository.getAllBudgetFacultyAndSpec(nameFaculty, nameSpec);
    }


    public ArrayList<CandidateApplication> getAllTollFacultyAndSpec(String nameFaculty,
                                                                    String nameSpec) {
        //auditService.printAction("Get all the applications for the toll from a specific specialization and faculty", auditService.getTimestamp_action());
        return applicationRepository.getAllTollFacultyAndSpec(nameFaculty, nameSpec);
    }

    public void removeAppByCnp(String Cnp) {
        //auditService.printAction("Delete an application by Cnp candidate", auditService.getTimestamp_action());

        CandidateApplication x = applicationRepository.getApplicationByCnp(Cnp);

        applicationRepository.removeAppByCnp(Cnp);

    }

//    public void loadApplications() {
//        //auditService.printAction("Load all applications from csv", auditService.getTimestamp_action());
//        applicationReadingService.readingApplications();
//    }
//
//    public void storeApplications() {
//        //auditService.printAction("Reload the applications in csv", auditService.getTimestamp_action());
//        applicationWritingService.reloadApplications();
//    }
}
