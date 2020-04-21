package Service;

import Model.Candidate;
import Model.CandidateApplication;
import Repository.ApplicationRepository;

import java.util.ArrayList;

public class ApplicationService
{
    private static ApplicationService instance = null;
    private ApplicationRepository applicationRepository = new ApplicationRepository();

    private ApplicationService(){ }

    public static ApplicationService getInstance()
    {
        if(instance == null)
        {
            instance = new ApplicationService();
        }
        return instance;
    }

    public void addApplication (CandidateApplication a)
    {
        applicationRepository.addApplication(a);
    }

    public void addAdmissionExamNoteByName(String LastName, String FirstName,
                                           double gradeExam1, double gradeExam2)
    {
        applicationRepository.addAdmissionExamNoteByName(LastName, FirstName,
                                                        gradeExam1, gradeExam2);
    }
    public void addAdmissionExamCandidate(CandidateApplication c,
                                          double gradeExam1, double gradeExam2)
    {
        applicationRepository.addAdmissionExamCandidate(c,gradeExam1, gradeExam2);
    }

    public CandidateApplication getApplicationByName (String FirstName, String LastName)
    {
        CandidateApplication application = applicationRepository.getApplicationByName(FirstName, LastName);

        if(application == null)
        {
            throw new NullPointerException ("The application for this name doesn't exist!");
        }
        return application;
    }

    public ArrayList<CandidateApplication> getApplicationsFacultyByName (String nameFaculty)
    {
        return applicationRepository.getApplicationsFacultyByName(nameFaculty);
    }

    public ArrayList<CandidateApplication> getApplicationsFacultyAndSpec (String nameFaculty,
                                                                          String nameSpecialization)
    {
        return applicationRepository.getApplicationsFacultyAndSpec(nameFaculty, nameSpecialization);
    }

    public ArrayList<CandidateApplication> getListOfApplications()
    {
        return applicationRepository.getListOfApplications();
    }

    public ArrayList<CandidateApplication> getAllBudgetCandidatesApp()
    {
        return applicationRepository.getAllBudgetCandidatesApp();
    }

    public ArrayList<CandidateApplication> getAllCountrysideCandidatesApp()
    {
        return applicationRepository.getAllCountrysideCandidatesApp();
    }

    public ArrayList<CandidateApplication> getAllMinorityCandidatesApp()
    {
        return applicationRepository.getAllMinorityCandidatesApp();
    }

    public ArrayList<CandidateApplication> getAllTollCandidates()
    {
        return applicationRepository.getAllTollCandidates();
    }

    public ArrayList<CandidateApplication> getAllBudgetFacultyAndSpec(String nameFaculty,
                                                                      String nameSpec)
    {
        return applicationRepository.getAllBudgetFacultyAndSpec(nameFaculty,nameSpec);
    }

    public ArrayList<CandidateApplication> getAllCountrysideFacultyAndSpec(String nameFaculty,
                                                                           String nameSpec)
    {
        return applicationRepository.getAllCountrysideFacultyAndSpec(nameFaculty, nameSpec);
    }

    public ArrayList<CandidateApplication> getAllMinorityFacultyAndSpec(String nameFaculty,
                                                                               String nameSpec)
    {
        return applicationRepository.getAllMinorityFacultyAndSpec(nameFaculty, nameSpec);
    }

    public ArrayList<CandidateApplication> getAllTollFacultyAndSpec(String nameFaculty,
                                                                    String nameSpec)
    {
        return applicationRepository.getAllTollFacultyAndSpec(nameFaculty, nameSpec);
    }

    public void removeAppByCnp(String Cnp)
    {
        CandidateService candidateService = CandidateService.getInstance();
        CandidateApplication x = applicationRepository.getApplicationByCnp(Cnp);

        if(x == null)
        {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }

        candidateService.removeCandidateByCnp(Cnp);
        applicationRepository.removeAppByCnp(Cnp);
    }
}
