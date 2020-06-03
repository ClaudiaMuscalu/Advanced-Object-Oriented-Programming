package Thread;

import Model.Faculty;
import Repository.FacultyRepository;
import Service.AuditService;

public class AddFacultyThread extends Thread{

    private final Faculty faculty;

    public AddFacultyThread(String nameThread, Faculty faculty) {
        this.setName(nameThread);
        this.faculty = faculty;
    }

    @Override
    public void run() {
        AuditService auditService = AuditService.getInstance();
        auditService.printAction("Add a new faculty", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        FacultyRepository.getInstance().addFaculty(faculty);
    }
}
