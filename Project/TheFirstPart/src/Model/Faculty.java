package Model;

import java.util.ArrayList;

public class Faculty
{
    private static int numberOfFaculties = 0;
    protected String name;
    protected String facultyCode;
    protected int budgetNumberPositions;
    protected int tollNumberPositions;
    protected int countrySideNumberPositions;
    protected int minorityNumberPositions;
    protected int totalNumberPositions;

    public Faculty(String name, String facultyCode, int budgetNumberPositions,
                   int tollNumberPositions, int countrySideNumberPositions, int minorityNumberPositions)
    {
        numberOfFaculties ++;
        this.name = name;
        this.facultyCode = facultyCode;
        this.budgetNumberPositions = budgetNumberPositions;
        this.tollNumberPositions = tollNumberPositions;
        this.countrySideNumberPositions = countrySideNumberPositions;
        this.minorityNumberPositions = minorityNumberPositions;
        this.totalNumberPositions = budgetNumberPositions + tollNumberPositions +
                                   + countrySideNumberPositions + minorityNumberPositions;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFacultyCode()
    {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode)
    {
        this.facultyCode = facultyCode;
    }

    public int getBudgetNumberPositions()
    {
        return budgetNumberPositions;
    }

    public void setBudgetNumberPositions(int budgetNumberPositions)
    {
        this.budgetNumberPositions = budgetNumberPositions;
    }

    public int getTollNumberPositions()
    {
        return tollNumberPositions;
    }

    public void setTollNumberPositions(int tollNumberPositions)
    {
        this.tollNumberPositions = tollNumberPositions;
    }

    public int getCountrySideNumberPositions()
    {
        return countrySideNumberPositions;
    }

    public void setCountrySideNumberPositions(int countrySideNumberPositions)
    {
        this.countrySideNumberPositions = countrySideNumberPositions;
    }

    public int getMinorityNumberPositions()
    {
        return minorityNumberPositions;
    }

    public void setMinorityNumberPositions(int minorityNumberPositions)
    {
        this.minorityNumberPositions = minorityNumberPositions;
    }
    public int getTotalNumberPositions()
    {
        return totalNumberPositions;
    }

    public void setTotalNumberPositions(int totalNumberPositions)
    {
        this.totalNumberPositions = totalNumberPositions;
    }

    @Override
    public String toString()
    {
        return "Faculty {" +
                "namefaculty='" + name + '\'' +
                ", facultyCode='" + facultyCode + '\'' +
                ", budgetNumberPositions=" + budgetNumberPositions +
                ", tollNumberPositions=" + tollNumberPositions +
                ", countrySideNumberPositions=" + countrySideNumberPositions +
                ", minorityNumberPositions=" + minorityNumberPositions +
                ", totalNumberPositions=" + totalNumberPositions +
                '}';
    }
}
