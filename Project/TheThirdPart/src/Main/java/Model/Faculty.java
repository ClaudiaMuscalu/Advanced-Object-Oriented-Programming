package Model;

public class Faculty {

    private static int id = 1;
    protected String facultyCode; // PK

    protected String nameFaculty;
    protected int budgetNumberPositions;
    protected int tollNumberPositions;

    public Faculty(){}

    public Faculty(String nameFaculty, int budgetNumberPositions, int tollNumberPositions)
    {
        this.facultyCode = "F" + id;
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
