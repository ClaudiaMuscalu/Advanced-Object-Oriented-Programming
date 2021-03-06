package Service;

import Model.CandidateApplication;
import Model.Specialization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistributionService {
    private static DistributionService instance = null;
    private ApplicationService applicationService = ApplicationService.getInstance();
    private SpecializationService specService = SpecializationService.getInstance();

    private DistributionService() {
    }

    public static DistributionService getInstance() {
        if (instance == null) {
            instance = new DistributionService();
        }
        return instance;
    }

    // Toti candidatii admisi la buget la o anumita specializare si o anumita facultate
    public List<CandidateApplication> getAdmittedCandidatesSpecB(String nameFaculty,
                                                                 String nameS) {
        ArrayList<CandidateApplication> a = applicationService.getAllBudgetFacultyAndSpec(nameFaculty, nameS);

        Specialization s = specService.getSpecByName(nameS);

        int numberOfPositions = s.getNumberOfPositionsBudget();

        Collections.sort(a);

        return a.subList(0, numberOfPositions);
    }

    // Toti candidatii admisi la taxa la o anumita specializare si o anumita facultate
    public List<CandidateApplication> getAdmittedCandidatesSpecT(String nameFaculty,
                                                                 String nameS) {
        ArrayList<CandidateApplication> t = applicationService.getAllTollFacultyAndSpec(nameFaculty, nameS);

        Specialization s = specService.getSpecByName(nameS);

        int numberOfPositions = s.getNumberOfPositionsToll();

        Collections.sort(t);

        return t.subList(0, numberOfPositions);
    }

    // Toti candidatii admisi la o anumita specializare si o anumita facultate care sunt minoritate
    public List<CandidateApplication> getAdmittedCandidatesSpecM(String nameFaculty,
                                                                 String nameS) {
        ArrayList<CandidateApplication> m = applicationService.getAllMinorityFacultyAndSpec(nameFaculty, nameS);

        Specialization s = specService.getSpecByName(nameS);

        int numberOfPositions = s.getMinorityNumberPositions();

        Collections.sort(m);


        return m.subList(0, numberOfPositions);
    }

    // Toti candidatii admisi la o anumita specializare si o anumita facultate din mediul rural
    public List<CandidateApplication> getAdmittedCandidatesSpecCS(String nameFaculty,
                                                                  String nameS) {
        ArrayList<CandidateApplication> cs = applicationService.getAllCountrysideFacultyAndSpec(nameFaculty, nameS);

        Specialization s = specService.getSpecByName(nameS);

        int numberOfPositions = s.getMinorityNumberPositions();

        Collections.sort(cs);

        return cs.subList(0, numberOfPositions);
    }

    // Toti candidatii admisi la o anumita specializare
    public ArrayList<CandidateApplication> getAllAdmittedCandidatesS(String nameFaculty,
                                                                     String Specialization) {
        List<CandidateApplication> a = this.getAdmittedCandidatesSpecB(nameFaculty, Specialization);
        List<CandidateApplication> b = this.getAdmittedCandidatesSpecT(nameFaculty, Specialization);
        List<CandidateApplication> c = this.getAdmittedCandidatesSpecM(nameFaculty, Specialization);
        List<CandidateApplication> d = this.getAdmittedCandidatesSpecCS(nameFaculty, Specialization);

        ArrayList<CandidateApplication> allAdmittedCandidatesS = new ArrayList<>();

        allAdmittedCandidatesS.addAll(a);
        allAdmittedCandidatesS.addAll(b);
        allAdmittedCandidatesS.addAll(c);
        allAdmittedCandidatesS.addAll(d);

        return allAdmittedCandidatesS;
    }
}