package Service;

import Model.CandidateApplication;
import Model.Specialization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistributionService {
    private static DistributionService instance = null;
    private ApplicationService applicationService = ApplicationService.getInstance();
    private SpecializationService specializationService = SpecializationService.getInstance();

    private DistributionService() {}

    public static DistributionService getInstance() {
        if (instance == null) {
            instance = new DistributionService();
        }
        return instance;
    }


    // Toti candidatii admisi la buget la o anumita specializare si o anumita facultate
    public List<CandidateApplication> getAdmittedCandidatesSpecB(String faculty_code,
                                                                 String code_spec) {

        ArrayList<CandidateApplication> a = applicationService.getAllAplicationsFacultyBudget(faculty_code,
                code_spec);

        Specialization s = specializationService.getSpecialization(code_spec);

        int numberOfPositions = s.getNumberOfPositionsBudget();

        Collections.sort(a);

        return a.subList(0, numberOfPositions);
    }

    // Toti candidatii respinsi ce au candidat la buget
    // la o anumita specializare si o anumita facultate
    public List<CandidateApplication> getRejectedCandidatesSpecB(String faculty_code,
                                                                 String code_spec) {

        ArrayList<CandidateApplication> a = applicationService.getAllAplicationsFacultyBudget(faculty_code,
                code_spec);

        Specialization s = specializationService.getSpecialization(code_spec);

        int numberOfPositions = s.getNumberOfPositionsBudget();

        Collections.sort(a);

        return a.subList(numberOfPositions, a.size());
    }

    // Toti candidatii admisi la taxa la o anumita specializare si o anumita facultate
    public List<CandidateApplication> getAdmittedCandidatesSpecT(String faculty_code,
                                                                 String code_spec) {
        ArrayList<CandidateApplication> a = applicationService.getAllAplicationsFacultyToll(faculty_code,
                code_spec);

        Specialization s = specializationService.getSpecialization(code_spec);

        int numberOfPositions = s.getNumberOfPositionsToll();

        Collections.sort(a);

        return a.subList(0, numberOfPositions);
    }

    // Toti candidatii respinsi ce au candidat pentru taxa
    // la o anumita specializare si o anumita facultate
    public List<CandidateApplication> getRejectedCandidatesSpecT(String faculty_code,
                                                                 String code_spec) {
        ArrayList<CandidateApplication> a = applicationService.getAllAplicationsFacultyToll(faculty_code,
                code_spec);

        Specialization s = specializationService.getSpecialization(code_spec);

        int numberOfPositions = s.getNumberOfPositionsToll();

        Collections.sort(a);

        return a.subList(numberOfPositions, a.size());
    }



}
