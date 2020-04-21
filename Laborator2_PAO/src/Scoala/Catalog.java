package Scoala;

public class Catalog
{
    private String grupa;
    private Student []C;
    public static int nr_studenti;

    public Catalog()
    {
        C = new Student[5];
    }

    public void adauga_student(Student s)
    {
        C[nr_studenti] = s;
        if(nr_studenti < 5)
            nr_studenti++;
    }

    public double getMedieClasa()
    {
        double M = 0.0;
        for(int i = 0; i < 5 ; i ++)
            M += C[i].getMedieAn1();
        return (M/5.0);
    }

    public String toString()
    {
        String afis = "Afisare catalog: \n";
        for(int i = 0; i < 5 ; i ++)
            afis += C[i].toString() + "\n";

        afis += "Medie anuala a celor 5 studenti: " + getMedieClasa() + "\n";
        return afis;
    }

    public static void main( String args[])
    {
        Catalog C = new Catalog();
        Student s1 = new Student("P. Andreea", 7.89, 9.23);
        Student s2 = new Student("H. George", 6.39, 7.23);
        Student s3 = new Student("C. Mihai", 8.59, 5.29);
        Student s4 = new Student("R. Lucia", 9.19, 8.23);
        Student s5 = new Student("G. Radu", 10, 5.75);

        C.adauga_student(s1);
        C.adauga_student(s2);
        C.adauga_student(s3);
        C.adauga_student(s4);
        C.adauga_student(s5);

        System.out.println(C.toString());
    }
}
