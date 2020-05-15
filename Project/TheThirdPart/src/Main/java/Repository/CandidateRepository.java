package Repository;

import Model.*;

import java.util.ArrayList;

public class CandidateRepository {

    private static final int units = 40;
    private int capacity = 20;
    private ArrayList<Candidate> CandidateList;

    public CandidateRepository() {

        CandidateList = new ArrayList<>(capacity);
    }

    public void addCandidate(Candidate c) {

        int size = CandidateList.size();
        int new_capacity = capacity + units;

        if (size == capacity)
            CandidateList.ensureCapacity(new_capacity);

        CandidateList.add(c);
    }

    public Candidate getCandidateByCNP(String CNP) {

        for (Candidate c : CandidateList) {
            if (c.getCnp().equals(CNP))
            {
                System.out.println("aaaa");
                return c;
            }

        }
        return null;
    }

    public ArrayList<Candidate> getAllCandidates() {

        return CandidateList;
    }

    public ArrayList<BudgetCandidate> getAllBudgetCandidates() {

        ArrayList<BudgetCandidate> budgetCandidates = new ArrayList<>();

        for (Candidate c : CandidateList) {

            if (c instanceof BudgetCandidate) {

                BudgetCandidate b = (BudgetCandidate) c;
                budgetCandidates.add(b);
            }
        }

        return budgetCandidates;
    }

    public ArrayList<TollCandidate> getAllTollCandidates() {

        ArrayList<TollCandidate> tollCandidates = new ArrayList<>();

        for (Candidate c : CandidateList) {

            if (c instanceof TollCandidate) {

                TollCandidate t = (TollCandidate) c;
                tollCandidates.add(t);
            }
        }

        return tollCandidates;
    }

    public void removeCandidateByCnp(String Cnp) {

        Candidate c = null;
        for (Candidate candidate : CandidateList) {

            if (candidate.getCnp().equals(Cnp)) {

                c = candidate;
            }
        }
        CandidateList.remove(c);
    }

    public void modifyCandidateNameByCnp(String Cnp, String NewName) {

        Candidate c = getCandidateByCNP(Cnp);
        c.setLastName(NewName);
    }
}
