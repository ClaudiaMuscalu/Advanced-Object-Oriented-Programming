package Service;

import Model.Faculty;
import Model.Specialization;
import Repository.SpecializationRepository;
import Service.CSVFile.AuditService;
import Service.CSVFile.SpecializationReadingService;
import Service.CSVFile.SpecializationWritingService;

import java.util.ArrayList;

public class SpecializationService {
    private static SpecializationService instance = null;
    private SpecializationRepository specializationRepository = new SpecializationRepository();

    private SpecializationReadingService specializationReadingService = SpecializationReadingService.getInstance(specializationRepository);
    private SpecializationWritingService specializationWritingService = SpecializationWritingService.getInstance(specializationRepository);
    private AuditService auditService = AuditService.getInstance();

    private SpecializationService() {
    }

    public static SpecializationService getInstance() {
        if (instance == null) {
            instance = new SpecializationService();
        }
        return instance;
    }

    public void addSpecialization(Specialization s) {
        auditService.printAction("Add a new specialization", auditService.getTimestamp_action());

        specializationRepository.addSpecialization(s);
        specializationWritingService.writeSpecialization(s);

    }

    public Specialization getSpecByName(String nameS) {
        auditService.printAction("Get a specialization by name", auditService.getTimestamp_action());

        return specializationRepository.getSpecByName(nameS);
    }

    public ArrayList<Specialization> getAllFacultySpecializations(Faculty f) {
        auditService.printAction("Get all specializations from a faculty: ", auditService.getTimestamp_action());
        return specializationRepository.getAllFacultySpecializations(f);
    }

    public ArrayList<Specialization> gelAllFacultySpecializationsByCode(String codeFaculty) {
        auditService.printAction("Get all specializations from a faculty by code:", auditService.getTimestamp_action());
        return specializationRepository.gelAllFacultySpecializationsByCode(codeFaculty);
    }

    public ArrayList<Specialization> getAllSpecializations() {
        auditService.printAction("Get all specilizations:", auditService.getTimestamp_action());
        return specializationRepository.getAllSpecializations();
    }

    public void loadSpecializations() {
        auditService.printAction("Load all specializations from csv", auditService.getTimestamp_action());
        specializationReadingService.readingSpecializations();
    }

    public void storeSpecializations() {
        auditService.printAction("Reload the faculties in csv", auditService.getTimestamp_action());
        specializationWritingService.reloadSpecializations();
    }
}

