package Thread;


import Model.Candidate;
import Repository.ApplicationRepository;
import Repository.CandidateRepository;
import Service.AuditService;

public class AddCandidateThread extends Thread{

    private final Candidate candidate;

    public AddCandidateThread(String nameThread, Candidate candidate){
        this.setName(nameThread);
        this.candidate = candidate;
    }

    @Override
    public void run() {
        AuditService auditService = AuditService.getInstance();
        auditService.printAction("Add a new candidate", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        CandidateRepository.getInstance().addCandidate(this.candidate);
    }
}
