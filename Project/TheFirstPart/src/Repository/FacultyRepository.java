package Repository;

import Model.Faculty;

import java.util.ArrayList;

public class FacultyRepository
{
    private ArrayList<Faculty>  faculties;

    public FacultyRepository()
    {
        faculties = new ArrayList<>();
    }

    public void addFaculty (Faculty f)
    {
        faculties.add(f);
    }

    public Faculty findFacultyByName(String name)
    {
        for(Faculty faculty : faculties)
        {
            if (faculty.getName().equals(name))
            {
                return faculty;
            }
        }
        return null;
    }

    public ArrayList<Faculty> getAllFaculties()
    {
        return faculties;
    }
}
