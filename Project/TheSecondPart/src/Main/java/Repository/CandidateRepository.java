package Repository;

import Model.*;

import java.util.ArrayList;

public class CandidateRepository {

    private ArrayList<Candidate> CandidateList = new ArrayList<>();

    public CandidateRepository() {
    }

    public void addCandidate(Candidate c) {

        CandidateList.add(c);
    }

    public Candidate getCandidateByCNP(String CNP) {
        for (Candidate c : CandidateList) {
            if (c.getCnp().equals(CNP))
                return c;
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

    public ArrayList<CountrysideCandidate> getAllCountrysideCandidates() {

        ArrayList<CountrysideCandidate> countrySideCandidates = new ArrayList<>();

        for (Candidate c : CandidateList) {

            if (c instanceof CountrysideCandidate) {

                CountrysideCandidate d = (CountrysideCandidate) c;
                countrySideCandidates.add(d);
            }
        }

        return countrySideCandidates;
    }

    public ArrayList<MinorityCandidate> getAllMinorityCandidates() {

        ArrayList<MinorityCandidate> minorityCandidates = new ArrayList<>();

        for (Candidate c : CandidateList) {

            if (c instanceof MinorityCandidate) {

                MinorityCandidate m = (MinorityCandidate) c;
                minorityCandidates.add(m);
            }
        }

        return minorityCandidates;
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
