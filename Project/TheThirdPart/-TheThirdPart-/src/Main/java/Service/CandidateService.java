package Service;

import Model.*;
import Repository.CandidateRepository;
import Thread.AddCandidateThread;

import java.util.ArrayList;



public class CandidateService {

    private static CandidateService instance = null;
    private CandidateRepository candidateRepository = CandidateRepository.getInstance();

    private AuditService auditService = AuditService.getInstance();

    private CandidateService() { }

    public static CandidateService getInstance() {

        if (instance == null) {
            instance = new CandidateService();
        }
        return instance;
    }

    public Candidate getCandidate(String CNP) {
        auditService.printAction("Get a candidate by CNP", auditService.getTimestamp_action(),
                Thread.currentThread().getName());

        Candidate x = candidateRepository.getCandidate(CNP);

        if (x == null) {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }
        System.out.println("b");
        return x;
    }

    public ArrayList<Candidate> getAllCandidates() {
        auditService.printAction("Get all candidates", auditService.getTimestamp_action(),
                 Thread.currentThread().getName());
        return candidateRepository.getAllCandidates();
    }

    public ArrayList<BudgetCandidate> getAllBudgetCandidates() {
        auditService.printAction("Get all budget candidates", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        return candidateRepository.getAllBudgetCandidates();
    }

    public ArrayList<TollCandidate> getAllTollCandidates() {
        auditService.printAction("Get all toll candidates", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        return candidateRepository.getAllTollCandidates();
    }

    public void addCandidate(Candidate c) {

        AddCandidateThread addCandidateThread = new AddCandidateThread("addCandidateThread", c);
        addCandidateThread.start();
    }

    public void updateLastName(String Cnp, String newName) {
        auditService.printAction("Modify the name of a candidate", auditService.getTimestamp_action(),
                Thread.currentThread().getName());

        Candidate x = candidateRepository.getCandidate(Cnp);

        if (x == null) {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }

        candidateRepository.updateLastName(Cnp, newName);
    }

    public void deleteCandidate(String Cnp) {
        auditService.printAction("Delete a candidate by CNP and delete his application.",
                auditService.getTimestamp_action(), Thread.currentThread().getName());

        Candidate x = candidateRepository.getCandidate(Cnp);

        if (x == null) {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }
        ApplicationService applicationService = ApplicationService.getInstance();
        ArrayList<CandidateApplication> listOfApp = applicationService.getAllAplications();

        if(listOfApp.isEmpty())
        {
            System.out.println("No application for this canidate");
        }
        else{
            for(CandidateApplication a : listOfApp){
                if(a.getCandidate().getCnp().equals(Cnp)){
                    applicationService.deleteApplication(a.getApplicationCode());
                }
            }
        }

        candidateRepository.deleteCandidate(Cnp);
    }
}
