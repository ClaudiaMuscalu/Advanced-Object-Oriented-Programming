package Service;

import Model.Specialization;
import Repository.SpecializationRepository;
import Thread.AddSpecializationThread;

import java.util.ArrayList;

public class SpecializationService {
    private static SpecializationService instance = null;
    private SpecializationRepository specializationRepository = new SpecializationRepository();

    private AuditService auditService = AuditService.getInstance();

    private SpecializationService(){}

    public static SpecializationService getInstance() {
        if (instance == null) {
            instance = new SpecializationService();
        }
        return instance;
    }

    public Specialization getSpecialization(String specializationCode) {
        auditService.printAction("Get a specialization", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        return specializationRepository.getSpecialization(specializationCode);
    }

    public ArrayList<Specialization> getAllSpecializations() {
        auditService.printAction("Get all specializations", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        return specializationRepository.getAllSpecializations();
    }

    public ArrayList<Specialization> getAllSpecializationsFromFaculty(String faculty_code) {
        auditService.printAction("Get all specializations from a faculty",
                auditService.getTimestamp_action(), Thread.currentThread().getName());
        return specializationRepository.getAllSpecializationsFromFaculty(faculty_code);
    }

    public void addSpecialization(Specialization s) {

        AddSpecializationThread addSpecializationThread = new AddSpecializationThread("addSpecThread", s);
        addSpecializationThread.start();

    }

    public void updateSpecializationName(String specializationCode, String newName) {
        auditService.printAction("Update the name of a specialization",
                auditService.getTimestamp_action(), Thread.currentThread().getName());
        specializationRepository.updateSpecializationName(specializationCode, newName);
    }

    public void deleteSpecialization(String specializationCode) {
        auditService.printAction("Delete a specialization",
                auditService.getTimestamp_action(), Thread.currentThread().getName());
        specializationRepository.deleteSpecialization(specializationCode);
    }
}

