package Problemele12345;

public class Complex
{
    private double real;
    private double img;

    public Complex()
    {
        this.real = 0;
        this.img = 0;
    }

    public Complex(double r, double i)
    {
        this.real = r;
        this.img = i;
    }

    Complex suma(Complex C)
    {
        Complex S = new Complex();
        S.real = this.real + C.real;
        S.img = this.img + C.img;

        return S;
    }

    boolean equals(Complex C)
    {
        if(this.real == C.real && this.img == C.img)
            return true;
        return false;
    }

    public String toString()
    {
        String afis ="";

        afis += this.real;
        if(this.img < 0)
            afis = afis + "-" + this.img;
        else
            if(this.img > 0)
                afis = afis + "+" + this.img;
        return afis;

    }

    public static void main(String args[])
    {
        Complex c1, c2, c3;
        c1 = new Complex(4,3);
        c2= new Complex(-2,4);
        c3= new Complex(4,3);

        System.out.println(c1.equals(c3));
        System.out.println(c1.suma(c2));
    }
}