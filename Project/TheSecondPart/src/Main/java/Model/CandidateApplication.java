package Model;

import java.util.Objects;

public class CandidateApplication implements Comparable<CandidateApplication> {
    private String admissionOption;
    private Specialization specialization;
    private Candidate candidate;
    private Faculty faculty;
    private double admissionExam;
    private double result;

    public CandidateApplication(String admissionOption, Specialization specialization,
                                Candidate candidate, Faculty faculty, double admissionExam) {

        this.admissionOption = admissionOption;
        this.specialization = specialization;
        this.candidate = candidate;
        this.faculty = faculty;
        this.admissionExam = admissionExam;

        if (admissionOption.equals("true"))
            this.result = (admissionExam + candidate.getBacResult()) / 2.0;
        else
            this.result = candidate.getBacResult();

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

    public double getAdmissionExam() {
        return admissionExam;
    }

    public void setAdmissionExam(double admissionExam) {
        this.admissionExam = admissionExam;
    }

    public String getAdmissionOption() {
        return admissionOption;
    }

    public void setAdmissionOption(String admissionOption) {
        this.admissionOption = admissionOption;
    }

    public double getResult() {
        return result;
    }

    public void setResult() {
        if (admissionOption.equals("true"))
            this.result = (candidate.getBacResult() + admissionExam) / 2.0;
        else
            this.result = candidate.getBacResult();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CandidateApplication application = (CandidateApplication) obj;

        return candidate.getCnp().equals(application.candidate.getCnp()) &&
                Double.compare(application.result, this.result) == 0 &&
                Objects.equals(candidate.getLastName(), application.candidate.getLastName()) &&
                Objects.equals(candidate.getFirstName(), application.candidate.getFirstName());

    }

    // Candidatii vor fi mai intai comparati dupa rezultatul obtinut => (admitere + bac)/2.0 daca dau admitere
    // altfel dupa media de bac
    // I. Daca este egal, atunci se vor compara dupa numele de familie
    // II. Daca au acelasi nume de familie, vor fi comparati dupa prenume
    // Ordinea este descrescatoare dupa rezultat

    @Override
    public int compareTo(CandidateApplication apl) {

        if (Double.compare(this.result, apl.result) == 0) {
            if (candidate.getLastName().equals(apl.candidate.getLastName()))
                return candidate.getFirstName().compareTo(apl.candidate.getFirstName());
            return candidate.getLastName().compareTo(apl.candidate.getLastName());
        }

        int comp = Double.compare(this.result, apl.result);
        return comp * (-1);
    }

    @Override
    public String toString() {
        String print = ("CandidateApplication {" + "admission?="
                + admissionOption + " specialization="
                + specialization.getNameS() + ", "
                + candidate.toString()
                + ", faculty=" + faculty.getName() + " bac="
                + String.format("%.2f", candidate.getBacResult()));
        if (admissionOption.equals("true")) {
            print += (" admissionexam="
                    + String.format("%.2f", admissionExam) + " result="
                    + String.format("%.2f", result) + "}");
        }
        return print;
    }
}
