package Problema7;

public class Magazin
{
    private Produs []M;
    public static int nr_produse = 0;
    private int capacity = 1000;

    Magazin()
    {
        M = new Produs[capacity];
    }

    public void adauga_produs(Produs x)
    {
        if(nr_produse == capacity)
            System.out.println("Magazinul nu mai poate primi produse noi");

        M[nr_produse] = x;
        nr_produse ++;
    }

    public double getTotalMagazin()
    {
        double T = 0.0;
        for(int i = 0 ; i < nr_produse ; i ++)
            T +=  M[i].getTotalProdus();
        return T;
    }

    public String toString()
    {
        String afis = "Componente magazin: \n";

        for(int i = 0 ; i < nr_produse ; i ++)
            afis += M[i].toString() + "\n";

        afis += "Total Magazin: " + this.getTotalMagazin();
        return afis;
    }

    public static void main(String args[])
    {
        Magazin M = new Magazin();
        Produs pr = new Produs("faina",3.5,4);
        Produs pr1 = new Produs("zahar",7.6,3);
        Produs pr2 = new Produs("praf de copt",2.67,3);
        Produs pr3 = new Produs("zahar pudra",6.5,1);

        M.adauga_produs(pr);
        M.adauga_produs(pr1);
        M.adauga_produs(pr2);
        M.adauga_produs(pr3);

        System.out.println(M.toString());
    }
}
