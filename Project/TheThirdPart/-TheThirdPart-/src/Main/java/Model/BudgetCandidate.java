package Model;

public class BudgetCandidate extends Candidate {
    public BudgetCandidate() {}

    public BudgetCandidate(String cnp, String candidateType, String firstName, String lastName, double bacResult) {
        super(cnp, candidateType, firstName, lastName, bacResult);
    }

    @Override
    public String toString() {
        return "BudgetCandidate{" + super.toString() + "}";
    }
}
