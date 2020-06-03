package Service;

import Model.Faculty;

import Model.Specialization;
import Repository.FacultyRepository;
import Thread.AddFacultyThread;

import java.util.ArrayList;

public class FacultyService {
    private static FacultyService instance = null;

    private FacultyRepository facultyRepository = new FacultyRepository();

    private AuditService auditService = AuditService.getInstance();

    private FacultyService() {
    }

    public static FacultyService getInstance() {
        if (instance == null) {
            instance = new FacultyService();
        }
        return instance;
    }

    public Faculty getFaculty(String facultyCode){

        return facultyRepository.getFaculty(facultyCode);
    }

    public ArrayList<Faculty> getAllFaculties(){

        return facultyRepository.getAllFaculties();
    }

    public void addFaculty(Faculty f){

        AddFacultyThread addFacultyThread = new AddFacultyThread("addFacultythread", f);
        addFacultyThread.start();
    }

    public void updateFacultyName(String facultycode, String newName) {
        auditService.printAction("Update the name of a faculty", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        facultyRepository.updateFacultyName(facultycode, newName);
    }

//    atunci cand se sterge o facultate se sterg toate specializarile de la aceea facultate
    public void deleteFaculty(String facultyCode) {
        auditService.printAction("Delete a faculty", auditService.getTimestamp_action(),
                Thread.currentThread().getName());
        facultyRepository.deleteFaculty(facultyCode);

        SpecializationService specializationService = SpecializationService.getInstance();
        ArrayList<Specialization> allSpec = specializationService.getAllSpecializations();

        for(Specialization s: allSpec){
            if(s.getFacultyCode().equals(facultyCode)){
                specializationService.deleteSpecialization(s.getCodeSpec());
            }
        }
    }


}