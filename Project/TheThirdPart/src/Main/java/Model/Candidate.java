package Model;

public class Candidate {

    private String cnp; //PK
    private String candidateType; // BUGET SAU TAXA

    private String firstName;
    private String lastName;

    private double BacResult;

    public  Candidate(){}

    public Candidate(String cnp, String candidateType, String firstName, String lastName, double bacResult) {
        this.cnp = cnp;
        this.candidateType = candidateType;
        this.firstName = firstName;
        this.lastName = lastName;
        BacResult = bacResult;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
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

    public double getBacResult() {
        return BacResult;
    }

    public void setBacResult(double bacResult) {
        BacResult = bacResult;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "cnp='" + cnp + '\'' +
                ", candidateType='" + candidateType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", BacResult=" + BacResult +
                '}';
    }
}
