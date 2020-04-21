package Model;

public class Candidate {

    private String firstName;
    private String lastName;
    private String cnp;
    private double BacResult;
    private String facultyCode;
    private String candidateType;

    public Candidate() {
    }

    public Candidate(String firstName, String lastName, String cnp,
                     double bacResult, String facultyCode, String candidateType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        BacResult = bacResult;
        this.facultyCode = facultyCode;
        this.candidateType = candidateType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public double getBacResult() {
        return BacResult;
    }

    public void setBacResult(double bacResult) {
        BacResult = bacResult;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", BacResult=" + BacResult +
                ", facultyCode='" + facultyCode + '\'' +
                ", candidateType='" + candidateType + '\'' +
                '}';
    }
}
