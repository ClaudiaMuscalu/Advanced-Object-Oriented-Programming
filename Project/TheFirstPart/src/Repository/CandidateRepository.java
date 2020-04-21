package Repository;

import Model.*;

import java.util.ArrayList;


public class CandidateRepository
{
    private static final int units = 40;
    private int capacity = 20;
    private ArrayList<Candidate> CandidateList;

    public CandidateRepository()
    {
        CandidateList = new ArrayList<>(capacity);
    }

    public CandidateRepository (ArrayList<Candidate> candidateList)
    {
        CandidateList = candidateList;
    }

    public void addCandidate (Candidate c)
    {
        int size = CandidateList.size();
        int new_capacity = capacity + units;

        if( size == capacity)
            CandidateList.ensureCapacity(new_capacity);

        CandidateList.add(c);
    }

    public Candidate getCandidateByCNP (String CNP)
    {
        for(Candidate c : CandidateList)
        {
            if(c.getCNP().equals(CNP))
                return c;
        }
        return null;
    }

    public ArrayList<Candidate> getAllCandidates()
    {
        return CandidateList;
    }

    public ArrayList<BudgetCandidate> getAllBudgetCandidates()
    {

        ArrayList<BudgetCandidate> budgetCandidates = new ArrayList<>();

        for(Candidate c : CandidateList)
        {
            if (c instanceof BudgetCandidate)
            {
                BudgetCandidate b = (BudgetCandidate) c;
                budgetCandidates.add(b);
            }
        }

        return budgetCandidates;
    }

    public ArrayList<CountrysideCandidate> getAllCountrysideCandidates()
    {

        ArrayList<CountrysideCandidate> countrySideCandidates = new ArrayList<>();

        for(Candidate c : CandidateList)
        {
            if (c instanceof CountrysideCandidate)
            {
                CountrysideCandidate d = (CountrysideCandidate) c;
                countrySideCandidates.add(d);
            }
        }

        return countrySideCandidates;
    }

    public ArrayList<MinorityCandidate> getAllMinorityCandidates()
    {

        ArrayList<MinorityCandidate> minorityCandidates= new ArrayList<>();

        for(Candidate c : CandidateList)
        {
            if (c instanceof MinorityCandidate)
            {
                MinorityCandidate m = (MinorityCandidate) c;
                minorityCandidates.add(m);
            }
        }

        return minorityCandidates;
    }

    public ArrayList<TollCandidate> getAllTollCandidates()
    {

        ArrayList<TollCandidate> tollCandidates= new ArrayList<>();

        for(Candidate c : CandidateList)
        {
            if (c instanceof TollCandidate)
            {
                TollCandidate t = (TollCandidate) c;
                tollCandidates.add(t);
            }
        }

        return tollCandidates;
    }

    public void removeCandidateByCnp(String Cnp)
    {
        Candidate c = null;
        for(Candidate candidate : CandidateList)
        {
            if (candidate.getCNP().equals(Cnp))
            {
                c = candidate;
            }
        }
        CandidateList.remove(c);
    }
}
