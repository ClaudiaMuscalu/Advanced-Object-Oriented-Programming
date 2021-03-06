package Service;

import Model.*;
import Repository.CandidateRepository;
import Service.CSVFile.AuditService;
import Service.CSVFile.CandidateReadingService;
import Service.CSVFile.CandidateWritingService;

import java.util.ArrayList;

public class CandidateService {

    private static CandidateService instance = null;
    private CandidateRepository candidateRepository = new CandidateRepository();
    private CandidateWritingService candidateWritingService = CandidateWritingService.getInstance(candidateRepository);
    private CandidateReadingService candidateReadingService = CandidateReadingService.getInstance(candidateRepository);
    private AuditService auditService = AuditService.getInstance();

    private CandidateService() {
    }

    public static CandidateService getInstance() {

        if (instance == null) {
            instance = new CandidateService();
        }
        return instance;
    }

    public void addCandidate(Candidate c) {
        auditService.printAction("Add a new candidate", auditService.getTimestamp_action());

        candidateRepository.addCandidate(c);
        candidateWritingService.writeCandidate(c);
    }

    public Candidate getCandidateByCNP(String CNP) {
        auditService.printAction("Get a candidate by CNP", auditService.getTimestamp_action());

        Candidate x = candidateRepository.getCandidateByCNP(CNP);

        if (x == null) {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }
        return x;
    }

    public ArrayList<Candidate> getAllCandidates() {
        auditService.printAction("Get all candidates", auditService.getTimestamp_action());
        return candidateRepository.getAllCandidates();
    }

    public ArrayList<BudgetCandidate> getAllBudgetCandidates() {
        auditService.printAction("Get all budget candidates", auditService.getTimestamp_action());
        return candidateRepository.getAllBudgetCandidates();
    }

    public ArrayList<CountrysideCandidate> getAllCountrysideCandidates() {
        auditService.printAction("Get all countryside candidates", auditService.getTimestamp_action());
        return candidateRepository.getAllCountrysideCandidates();
    }

    public ArrayList<MinorityCandidate> getAllMinorityCandidates() {
        auditService.printAction("Get all minority candidates", auditService.getTimestamp_action());
        return candidateRepository.getAllMinorityCandidates();
    }

    public ArrayList<TollCandidate> getAllTollCandidates() {
        auditService.printAction("Get all toll candidates", auditService.getTimestamp_action());
        return candidateRepository.getAllTollCandidates();
    }

    public void removeCandidateByCnp(String Cnp) {
        auditService.printAction("Delete a candidate by CNP and delete his application.", auditService.getTimestamp_action());

        Candidate x = candidateRepository.getCandidateByCNP(Cnp);

        if (x == null) {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }

        candidateRepository.removeCandidateByCnp(Cnp);

        ApplicationService applicationService = ApplicationService.getInstance();
        applicationService.removeAppByCnp(Cnp);
        applicationService.storeApplications();

        storeCandidates();
    }

    public void modifyCandidateNameByCnp(String Cnp, String NewName) {
        auditService.printAction("Modify the name of a candidate", auditService.getTimestamp_action());

        Candidate x = candidateRepository.getCandidateByCNP(Cnp);

        if (x == null) {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }

        candidateRepository.modifyCandidateNameByCnp(Cnp, NewName);

        storeCandidates();

    }

    public void loadCandidates() {
        auditService.printAction("Load all candidates from csv", auditService.getTimestamp_action());
        candidateReadingService.readingCandidates();
    }

    public void storeCandidates() {
        auditService.printAction("Reload the candidates in csv", auditService.getTimestamp_action());
        candidateWritingService.reloadCandidates();
    }
}
