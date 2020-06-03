package Thread;

import Model.Specialization;
import Repository.SpecializationRepository;
import Service.AuditService;

public class AddSpecializationThread extends Thread {

    private final Specialization specialization;

    public AddSpecializationThread(String nameThread, Specialization specialization) {
        this.setName(nameThread);
        this.specialization = specialization;
    }

    @Override
    public void run() {
        AuditService auditService = AuditService.getInstance();
        auditService.printAction("Add a new specialization", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        SpecializationRepository.getInstance().addSpecialization(specialization);
    }
}
