package Service;

import Model.Faculty;
import Model.Specialization;
import Repository.SpecializationRepository;

import java.util.ArrayList;

public class SpecializationService
{
    private static SpecializationService instance = null;
    private SpecializationRepository specializationRepository = new SpecializationRepository();

    private SpecializationService()
    { }

    public static SpecializationService getInstance()
    {
        if(instance == null)
        {
            instance = new SpecializationService();
        }
        return instance;
    }

    public Specialization getSpecByName(String nameS)
    {
        return specializationRepository.getSpecByName(nameS);
    }

    public void addSpecialization(Specialization s)
    {
        specializationRepository.addSpecialization(s);
    }

    public ArrayList<Specialization> getAllFacultySpecializations(Faculty f)
    {
        return specializationRepository.getAllFacultySpecializations(f);
    }

    public ArrayList<Specialization> gelAllFacultySpecializationsByCode(String codeFaculty)
    {
        return specializationRepository.gelAllFacultySpecializationsByCode(codeFaculty);
    }

    public ArrayList<Specialization> getAllSpecializations()
    {
        return specializationRepository.getAllSpecializations();
    }
}

