package Problema7;

public class Produs
{
    private String nume;
    private double pret;
    private int cantitate;

    public  Produs()
    {
        this.nume = "";
        this. pret = 0.0;
        this.cantitate = 0;
    }

    public Produs(String n, double p, int c)
    {
        this.nume = n;
        this.pret = p;
        this.cantitate = c;
    }

    public double getTotalProdus()
    {
        return  this.pret * this.cantitate;
    }

    public String toString()
    {
        String afis = "Produs: " + this.nume + ";";
        afis += " pret: " + this.pret + ";";
        afis += " cantitate: " + this.cantitate + ";";
        return afis;
    }

    public static void main(String args[])
    {
        Produs pr = new Produs("faina",3.5,4);
        System.out.println(pr.toString());
    }
}
