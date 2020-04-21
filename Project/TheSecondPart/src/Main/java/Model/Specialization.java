package Model;

public class Specialization {
    private static int numberOfSpecializations = 0;
    protected int countrySideNumberPositions;
    protected int minorityNumberPositions;
    protected String facultyCode;
    private String code;
    private String nameS;
    private int numberOfPositionsBudget;
    private int numberOfPositionsToll;

    public Specialization(String nameS) {
        this.nameS = nameS;
    }

    public Specialization(String code, String nameS, int numberOfPositionsBudget, int numberOfPositionsToll,
                          int countrySideNumberPositions, int minority, String facultyCode) {
        numberOfSpecializations++;
        this.code = code;
        this.nameS = nameS;
        this.numberOfPositionsBudget = numberOfPositionsBudget;
        this.numberOfPositionsToll = numberOfPositionsToll;
        this.countrySideNumberPositions = countrySideNumberPositions;
        this.minorityNumberPositions = minority;
        this.facultyCode = facultyCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameS() {
        return nameS;
    }

    public void setNameS(String nameS) {
        this.nameS = nameS;
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

    public String getFacultyCode() {
        return this.facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public int getCountrySideNumberPositions() {
        return countrySideNumberPositions;
    }

    public void setCountrySideNumberPositions(int countrySideNumberPositions) {
        this.countrySideNumberPositions = countrySideNumberPositions;
    }

    public int getMinorityNumberPositions() {
        return minorityNumberPositions;
    }

    public void setMinorityNumberPositions(int minorityNumberPositions) {
        this.minorityNumberPositions = minorityNumberPositions;
    }

    @Override
    public String toString() {
        return "Specialization {" +
                "code='" + code + '\'' +
                ", nameS='" + nameS + '\'' +
                ", numberOfPositionsBudget=" + numberOfPositionsBudget +
                ", numberOfPositionsToll=" + numberOfPositionsToll +
                ", countrySideNumberPositions=" + countrySideNumberPositions +
                ", minorityNumberPositions=" + minorityNumberPositions +
                ", facultyCode='" + facultyCode + '\'' +
                '}';
    }
}
