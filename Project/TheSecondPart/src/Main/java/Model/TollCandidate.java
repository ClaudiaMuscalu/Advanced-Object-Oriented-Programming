package Model;

public class TollCandidate extends Candidate {
    public TollCandidate() {
    }

    public TollCandidate(String firstName, String lastName, String cnp,
                         double bacResult, String facultyCode, String candidateType) {
        super(firstName, lastName, cnp, bacResult, facultyCode, candidateType);
    }

    @Override
    public String toString() {
        return "Candidate {" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", cnp='" + getCnp() + '\'' +
                ", bac=" + getBacResult() +
                ", facultyCode='" + getFacultyCode() + '\'' +
                ", typecandidate= " + getCandidateType() + '\'' +
                '}';
    }
}
