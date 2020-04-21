package Problema8;
import java.util.Arrays;

public class Student
{
    private String nume;
    private String prenume;
    public static int contor;

    public Student()
    {
        nume = "";
        prenume = "";
    }

    public Student(String N, String M)
    {
        contor ++;
        this.nume = N;
        this.prenume = M;
    }

    public String toString()
    {
        String afis = "Informatii student: \n";
        afis += "Nume: " + this.nume + ", ";
        afis += "Prenume: " + this.prenume + "\n";
        return afis;
    }

     public static void main(String args[])
     {
         Student S1, S2, S3, S4, S5;
         Student []S = new Student[5];

         S1 = new Student("Popescu", "Ion");
         S2 = new Student("Dimitrie", "Costin");
         S3 = new Student("Astanei", "Violeta");
         S4 = new Student("Muscalu", "Claudia");
         S5 = new Student("Peste", "Ioana");

         S[0] = S1;
         S[1] = S2;
         S[2] = S3;
         S[3] = S4;
         S[4] = S5;

         for(int i = 0 ; i < Student.contor ; i ++)
             System.out.println(S[i].toString());

         System.out.println("Valoare contor: "  + Student.contor);
     }
}
