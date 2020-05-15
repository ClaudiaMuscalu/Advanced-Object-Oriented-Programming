package Service;

import Model.Faculty;

import Repository.FacultyRepository;

import java.util.ArrayList;

public class FacultyService {
    private static FacultyService instance = null;

    private FacultyRepository facultyRepository = new FacultyRepository();


    private FacultyService() {
    }

    public static FacultyService getInstance() {
        if (instance == null) {
            instance = new FacultyService();
        }
        return instance;
    }

    public void add(Faculty f) {
        //auditService.printAction("Add a new faculty", auditService.getTimestamp_action());

        facultyRepository.addFaculty(f);
    }

    public Faculty findFacultyByName(String name) {
        //auditService.printAction("Find a faculty by name", auditService.getTimestamp_action());

        Faculty x = facultyRepository.findFacultyByName(name);
        if (x == null) {
            throw new NullPointerException("This faculty doesn't exist");
        }

        return x;
    }

    public ArrayList<Faculty> getAllFaculties() {
        //auditService.printAction("Get all faculties", auditService.getTimestamp_action());
        return facultyRepository.getAllFaculties();
    }

//    public void loadFaculties() {
//        //auditService.printAction("Load all faculties from csv", auditService.getTimestamp_action());
//        facultyReadingService.readingFaculties();
//    }
//
//    public void storeCandidates() {
//        auditService.printAction("Reload the faculties in csv", auditService.getTimestamp_action());
//        facultyWritingService.reloadFaculties();
//    }
}
