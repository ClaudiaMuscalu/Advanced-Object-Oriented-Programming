package Repository;

import Model.Faculty;
import Model.Specialization;

import java.util.ArrayList;

public class SpecializationRepository {
    private ArrayList<Specialization> listOfSpecializations;

    public SpecializationRepository() {
        this.listOfSpecializations = new ArrayList<>();
    }


    public Specialization getSpecByName(String nameS) {
        Specialization s = null;
        for (Specialization x : listOfSpecializations) {
            if (x.getNameS().equals(nameS)) {
                s = x;
            }
        }
        if (s == null) {
            throw new NullPointerException("This specialization doesn't exist!");
        }
        return s;
    }

    public void addSpecialization(Specialization s) {
        listOfSpecializations.add(s);
    }

    public ArrayList<Specialization> getAllFacultySpecializations(Faculty f) {
        ArrayList<Specialization> S = new ArrayList<>();

        for (Specialization s : listOfSpecializations) {
            if (s.getFacultyCode().equals(f.getFacultyCode())) {
                S.add(s);
            }
        }
        return S;
    }

    public ArrayList<Specialization> gelAllFacultySpecializationsByCode(String codeFaculty) {
        ArrayList<Specialization> SpecializationsOfFaculty = new ArrayList<>();

        for (Specialization s : listOfSpecializations) {
            if (s.getFacultyCode().equals(codeFaculty)) {
                SpecializationsOfFaculty.add(s);
            }
        }
        return SpecializationsOfFaculty;
    }

    public ArrayList<Specialization> getAllSpecializations() {
        return listOfSpecializations;
    }

}
