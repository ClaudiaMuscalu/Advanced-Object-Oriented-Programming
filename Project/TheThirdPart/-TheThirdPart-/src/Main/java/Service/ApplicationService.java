package Service;

import Model.CandidateApplication;
import Repository.ApplicationRepository;
import Thread.AddApplicationThread;

import java.util.ArrayList;

public class ApplicationService {

    private static ApplicationService instance = null;
    private ApplicationRepository applicationRepository = new ApplicationRepository();

    private AuditService auditService = AuditService.getInstance();

    private ApplicationService(){}

    public static ApplicationService getInstance() {
        if (instance == null) {
            instance = new ApplicationService();
        }
        return instance;
    }

    public CandidateApplication getApplication(String code_app){
        return applicationRepository.getApplication(code_app);
    }

    public ArrayList<CandidateApplication> getAllAplications() {
        return applicationRepository.getAllAplications();
    }

    public void addApplication(CandidateApplication a) {

        AddApplicationThread addApplicationThread = new AddApplicationThread("addAppThread", a);
        addApplicationThread.start();
    }

    public ArrayList<CandidateApplication> getAllAplicationsFaculty(String faculty_code) {
        auditService.printAction("Get all aplications", auditService.getTimestamp_action(),
                Thread.currentThread().getName());

        return applicationRepository.getAllAplicationsFaculty(faculty_code);
    }

    public ArrayList<CandidateApplication> getAllAplicationsFacultyBudget(String faculty_code,
                                                                          String code_spec) {
        auditService.printAction("Get applications to the the budget" +
                " by faculty code", auditService.getTimestamp_action(), Thread.currentThread().getName());

        return applicationRepository.getAllAplicationsFacultyBudget(faculty_code, code_spec);
    }

    public ArrayList<CandidateApplication> getAllAplicationsFacultyToll(String faculty_code,
                                                                        String code_spec) {
        auditService.printAction("Get applications to the the toll" +
                " by faculty code", auditService.getTimestamp_action(), Thread.currentThread().getName());

        return applicationRepository.getAllAplicationsFacultyToll(faculty_code, code_spec);
    }
    public void addAdmissionResult(String code_app, double result) {
        auditService.printAction("Add admission result", auditService.getTimestamp_action(),
                Thread.currentThread().getName());

        applicationRepository.addAdmissionResult(code_app, result);
        updateResult(code_app);
    }

    public void updateResult(String code_app) {
        auditService.printAction("Update admission result", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        applicationRepository.updateResult(code_app);
    }

    public void deleteApplication(String code_app) {
        auditService.printAction("Delete an application by id", auditService.getTimestamp_action(),
                Thread.currentThread().getName());

        applicationRepository.deleteApplication(code_app);
    }
}
