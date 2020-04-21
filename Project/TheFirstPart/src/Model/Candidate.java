package Model;

import java.util.Objects;

public class Candidate
{
    protected Baccalaureate bac;
    private String firstName;
    private String lastName;
    private String cnp;
    private String facultyCode;

    public Candidate(){}

    public Candidate(String firstName, String lastName, String CNP, double gradebac1,
                     double gradebac2, double gradebac3, String facultyCode)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = CNP;
        this.bac = new Baccalaureate(gradebac1, gradebac2, gradebac3);
        this.facultyCode = facultyCode;
    }

    public Candidate(String firstName, String lastName, String CNP,
                     Baccalaureate bac, String facultyCode)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = CNP;
        this.bac = bac;
        this.facultyCode = facultyCode;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getCNP()
    {
        return this.cnp;
    }

    public void setCNP(String CNP)
    {
        this.cnp = CNP;
    }

    public Baccalaureate getBac()
    {
        return this.bac;
    }

    public void setBac(Baccalaureate bac)
    {
        this.bac = bac;
    }

    public String getFacultyCode()
    {
        return this.facultyCode;
    }

    public void setFacultyCode(String facultyCode)
    {
        this.facultyCode = facultyCode;
    }

    @Override
    public String toString()
    {
        return "Candidate {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", bac=" + bac.getEndResult() +
                ", facultyCode='" + facultyCode + '\'' +
                '}';
    }
}
