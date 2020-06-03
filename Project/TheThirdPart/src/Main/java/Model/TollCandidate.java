package Model;

public class TollCandidate extends Candidate {
    public TollCandidate() {}

    public TollCandidate(String cnp, String candidateType, String firstName, String lastName, double bacResult) {
        super(cnp, candidateType, firstName, lastName, bacResult);
    }

    @Override
    public String toString() {
        return "TollCandidate{" + super.toString() + "}";
    }
}
