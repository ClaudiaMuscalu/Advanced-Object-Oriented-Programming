package Model;

public class Faculty {

    protected String facultyCode; // PK
    private static int numberFaculty = 1;
    protected String nameFaculty;
    protected int budgetNumberPositions;
    protected int tollNumberPositions;

    public Faculty(){}

    public Faculty(String nameFaculty, int budgetNumberPositions, int tollNumberPositions)
    {
        this.facultyCode = "F" + numberFaculty;
        numberFaculty ++;
        this.nameFaculty = nameFaculty;
        this.budgetNumberPositions = budgetNumberPositions;
        this.tollNumberPositions = tollNumberPositions;
    }

    public Faculty(String facultyCode, String nameFaculty, int budgetNumberPositions, int tollNumberPositions)
    {
        this.facultyCode = facultyCode;
        numberFaculty ++;
        this.nameFaculty = nameFaculty;
        this.budgetNumberPositions = budgetNumberPositions;
        this.tollNumberPositions = tollNumberPositions;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public int getBudgetNumberPositions() {
        return budgetNumberPositions;
    }

    public void setBudgetNumberPositions(int budgetNumberPositions) {
        this.budgetNumberPositions = budgetNumberPositions;
    }

    public int getTollNumberPositions() {
        return tollNumberPositions;
    }

    public void setTollNumberPositions(int tollNumberPositions) {
        this.tollNumberPositions = tollNumberPositions;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyCode='" + facultyCode + '\'' +
                ", nameFaculty='" + nameFaculty + '\'' +
                ", budgetNumberPositions=" + budgetNumberPositions +
                ", tollNumberPositions=" + tollNumberPositions +
                '}';
    }
}
