package Thread;

import Model.CandidateApplication;
import Repository.ApplicationRepository;
import Service.AuditService;

public class AddApplicationThread extends Thread{

    private final CandidateApplication candidateApplication;

    public AddApplicationThread(String nameThread, CandidateApplication candidateApplication){
        this.setName(nameThread);
        this.candidateApplication = candidateApplication;
    }

    @Override
    public void run() {
        AuditService auditService = AuditService.getInstance();
        auditService.printAction("Add a new app", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        ApplicationRepository.getInstance().addApplication(this.candidateApplication);
    }
}
