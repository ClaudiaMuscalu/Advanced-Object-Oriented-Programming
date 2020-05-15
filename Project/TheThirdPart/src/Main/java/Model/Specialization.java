package Model;

public class Specialization {

    private String codeSpec; // PK
    private static int numberOfSpecialization = 1;

    protected String facultyCode; // FK

    private String nameSpec;

    private int numberOfPositionsBudget;
    private int numberOfPositionsToll;

    Specialization(){}

    public Specialization(String facultyCode, String nameSpec, int numberOfPositionsBudget, int numberOfPositionsToll) {
        this.codeSpec = "S" + numberOfSpecialization;
        this.facultyCode = facultyCode;
        this.nameSpec = nameSpec;
        this.numberOfPositionsBudget = numberOfPositionsBudget;
        this.numberOfPositionsToll = numberOfPositionsToll;
    }

    public String getCodeSpec() {
        return codeSpec;
    }

    public void setCodeSpec(String codeSpec) {
        this.codeSpec = codeSpec;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getNameSpec() {
        return nameSpec;
    }

    public void setNameSpec(String nameSpec) {
        this.nameSpec = nameSpec;
    }

    public int getNumberOfPositionsBudget() {
        return numberOfPositionsBudget;
    }

    public void setNumberOfPositionsBudget(int numberOfPositionsBudget) {
        this.numberOfPositionsBudget = numberOfPositionsBudget;
    }

    public int getNumberOfPositionsToll() {
        return numberOfPositionsToll;
    }

    public void setNumberOfPositionsToll(int numberOfPositionsToll) {
        this.numberOfPositionsToll = numberOfPositionsToll;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "codeSpec='" + codeSpec + '\'' +
                ", facultyCode='" + facultyCode + '\'' +
                ", nameSpec='" + nameSpec + '\'' +
                ", numberOfPositionsBudget=" + numberOfPositionsBudget +
                ", numberOfPositionsToll=" + numberOfPositionsToll +
                '}';
    }
}
