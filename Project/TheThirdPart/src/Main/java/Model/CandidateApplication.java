package Model;

import java.util.Objects;

public class CandidateApplication implements Comparable<CandidateApplication> {

    private String applicationCode; // PK
    private static int numberOfApp = 1;

    private String codeSpec; //FK
    private String facultyCode; //FK
    private Candidate candidate;//FK

    private String admissionOption;
    private double admissionExam;
    private double result;

    public CandidateApplication(String codeSpec, String facultyCode, Candidate candidate, String admissionOption, double admissionExam) {
        this.applicationCode = "A" + numberOfApp;
        this.codeSpec = codeSpec;
        this.facultyCode = facultyCode;
        this.candidate = candidate;
        this.admissionOption = admissionOption;
        this.admissionExam = admissionExam;

        if (admissionOption.equals("true"))
            this.result = (admissionExam + candidate.getBacResult()) / 2.0;
        else
            this.result = candidate.getBacResult();
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    public static int getNumberOfApp() {
        return numberOfApp;
    }

    public static void setNumberOfApp(int numberOfApp) {
        CandidateApplication.numberOfApp = numberOfApp;
    }

    public String getCodeSpec() {
        return codeSpec;
    }

    public void setCodeSpec(String codeSpec) {
        this.codeSpec = codeSpec;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getAdmissionOption() {
        return admissionOption;
    }

    public void setAdmissionOption(String admissionOption) {
        this.admissionOption = admissionOption;
    }

    public double getAdmissionExam() {
        return admissionExam;
    }

    public void setAdmissionExam(double admissionExam) {
        this.admissionExam = admissionExam;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
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
        return "CandidateApplication{" +
                "applicationCode='" + applicationCode + '\'' +
                ", codeSpec='" + codeSpec + '\'' +
                ", facultyCode='" + facultyCode + '\'' +
                ", candidate=" + candidate.toString() +
                ", admissionOption='" + admissionOption + '\'' +
                ", admissionExam=" + admissionExam +
                ", result=" + result +
                '}';
    }
}
