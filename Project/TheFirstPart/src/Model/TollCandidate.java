package Model;

public class TollCandidate extends Candidate
{
    public TollCandidate(String firstName, String lastName, String CNP, double gradebac1,
                         double gradebac2, double gradebac3, String facultyCode)
    {
        super(firstName, lastName, CNP, gradebac1, gradebac2, gradebac3, facultyCode);
    }

    public TollCandidate(String firstName, String lastName, String CNP, Baccalaureate bac,
                         String facultyCode)
    {
        super(firstName, lastName, CNP, bac, facultyCode);
    }

    @Override
    public String toString() {
        return "Candidate {" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", cnp='" + getCNP() + '\'' +
                ", bac=" + bac.getEndResult() +
                ", facultyCode='" + getFacultyCode() + '\'' +
                ", typecandidate= tollCandidate" +
                '}';
    }
}
