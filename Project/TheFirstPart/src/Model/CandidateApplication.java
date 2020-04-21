package Model;

import java.util.Objects;

public class CandidateApplication implements Comparable<CandidateApplication>
{
    private boolean admissionOption;
    private Specialization specialization;
    private Candidate candidate;
    private Faculty faculty;
    private AdmissionExam admissionExam;
    private double result;

    public CandidateApplication(boolean admissionOption, Specialization specialization, Candidate candidate,
                                Faculty faculty)
    {
        this.admissionOption = admissionOption;
        this.specialization = specialization;
        this.candidate = candidate;
        this.faculty = faculty;
    }

    public boolean getAdmissionOption() {
        return admissionOption;
    }

    public void setAdmissionOption(boolean admissionOption) {
        this.admissionOption = admissionOption;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public AdmissionExam getAdmissionExam() {
        return admissionExam;
    }

    public void setAdmissionExam(AdmissionExam admissionExam) { this.admissionExam = admissionExam; }

    public double getResult() {
        return result;
    }

    public void setResult()
    {
        double endResultAdmission = admissionExam.getExamResult();
        this.result = (candidate.getBac().getEndResult() + endResultAdmission) / 2.0;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CandidateApplication application = (CandidateApplication) obj;

        return  candidate.getCNP().equals(application.candidate.getCNP()) &&
                Double.compare(application.result, this.result) == 0 &&
                Objects.equals(candidate.getLastName(), application.candidate.getLastName()) &&
                Objects.equals(candidate.getFirstName(), application.candidate.getFirstName());

    }

    // Candidatii vor fi mai intai comparati dupa rezultatul obtinut => (admitere + bac)/2.0
    // I. Daca este egal, atunci se vor compara dupa numele de familie
    // II. Daca au acelasi nume de familie, vor fi comparati dupa prenume
    // Ordinea este descrescatoare dupa rezultat

    @Override
    public int compareTo(CandidateApplication apl) {

        if(Double.compare(this.result, apl.result) == 0)
        {
            if(candidate.getLastName().equals(apl.candidate.getLastName()))
                return candidate.getFirstName().compareTo(apl.candidate.getFirstName());
            return candidate.getLastName().compareTo(apl.candidate.getLastName());
        }

        int comp = Double.compare(this.result, apl.result);
        return comp * (-1);
    }

    @Override
    public String toString() {
        return ("CandidateApplication {" + "admission?:"
                + admissionOption + " specialization= "
                + specialization.getNameS() + ", candidate= "
                + candidate.getLastName() + " " + candidate.getFirstName()
                + ", faculty=" + faculty.getName());
    }

    public String print()
    {
        String print = ("CandidateApplication {" + "admission?="
                + admissionOption + " specialization="
                + specialization.getNameS() + ", candidate="
                + candidate.getLastName() + " " + candidate.getFirstName()
                + ", faculty=" + faculty.getName() + " bac="
                +  String.format("%.2f", candidate.getBac().getEndResult()));
        if(admissionOption)
        {
            print += (" admissionexam="
                    + admissionExam.getGradeExam1() + ", "
                    + admissionExam.getGradeExam2() + " result="
                    + String.format("%.2f", result));
        }
        return print;
    }
}
