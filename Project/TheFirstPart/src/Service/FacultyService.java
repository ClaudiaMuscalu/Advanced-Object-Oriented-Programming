package Service;

import Model.Faculty;

import Repository.FacultyRepository;

import java.util.ArrayList;

public class FacultyService
{
    private static FacultyService instance = null;
    private FacultyRepository facultyRepository =  new FacultyRepository();

    private FacultyService(){}

    public static FacultyService getInstance()
    {
        if(instance == null)
        {
            instance = new FacultyService();
        }
        return instance;
    }

    public void add (Faculty f)
    {
        facultyRepository.addFaculty(f);
    }

    public Faculty findFacultyByName(String name )
    {
        Faculty x = facultyRepository.findFacultyByName(name);
        if(x == null)
        {
            throw new NullPointerException("This faculty doesn't exist");
        }

        return x;
    }

    public ArrayList<Faculty> getAllFaculties()
    {
        return facultyRepository.getAllFaculties();
    }
}
