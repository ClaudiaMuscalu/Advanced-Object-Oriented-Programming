package Scoala;

public class Student
{
    private String nume;
    private double medieSem1;
    private double medieSem2;

    public Student()
    {
        this.nume = "";
        this.medieSem1 = 0.0;
        this.medieSem2 = 0.0;
    }

    public Student(String N, double n1, double n2)
    {
        this.nume = N;
        this.medieSem1 = n1;
        this.medieSem2 = n2;
    }

    public double getMedieAn1()
    {
        return ((this.medieSem1+this.medieSem2)/2.0);
    }

    public String toString()
    {
        String afis = " Informatii student:";
        afis += this.nume + " " + this.medieSem1+ " ";
        afis += this.medieSem2 + " " + this.getMedieAn1() + "\n";
        return afis;
    }

    public static void main(String args[]){}
}
