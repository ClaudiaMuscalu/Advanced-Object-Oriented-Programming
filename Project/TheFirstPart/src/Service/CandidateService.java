package Service;

import Model.*;
import Repository.CandidateRepository;

import java.util.ArrayList;

public class CandidateService
{
    private static CandidateService instance = null;
    private CandidateRepository candidateRepository = new CandidateRepository();

    private CandidateService(){}

    public static CandidateService getInstance()
    {
        if(instance == null)
        {
            instance = new CandidateService();
        }
        return instance;
    }

    public void addCandidate (Candidate c)
    {
        candidateRepository.addCandidate(c);

    }

    public Candidate getCandidateByCNP (String CNP)
    {
        Candidate x = candidateRepository.getCandidateByCNP(CNP);
        if(x == null)
        {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }
        return x;
    }

    public ArrayList<Candidate> getCandidates()
    {
        return candidateRepository.getAllCandidates();
    }

    public ArrayList<BudgetCandidate> getAllBudgetCandidates()
    {
        return candidateRepository.getAllBudgetCandidates();
    }


    public ArrayList<CountrysideCandidate> getAllCountrysideCandidates()
    {
        return candidateRepository.getAllCountrysideCandidates();
    }

    public ArrayList<MinorityCandidate> getAllMinorityCandidates()
    {
        return candidateRepository.getAllMinorityCandidates();
    }

    public ArrayList<TollCandidate> getAllTollCandidates()
    {
        return candidateRepository.getAllTollCandidates();
    }

    public void removeCandidateByCnp(String Cnp)
    {
        Candidate x = candidateRepository.getCandidateByCNP(Cnp);

        if(x == null)
        {
            throw new NullPointerException("x is null, the candidate with this CNP doesn't exist!");
        }

        candidateRepository.removeCandidateByCnp(Cnp);
    }
}
