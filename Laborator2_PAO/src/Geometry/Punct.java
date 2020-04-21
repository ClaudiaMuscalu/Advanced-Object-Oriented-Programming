package Geometry;

public class Punct
{
    private int x;
    private int y;

    public Punct()
    {
        this.x = 0;
        this.y = 0;
    }

    public Punct(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }

    public int getX()
    {
        return this.x;
    }

    public void setX(int X)
    {
        this.x = X;
    }

    public int getY()
    {
        return this.y;
    }

    public void setY(int Y)
    {
        this.y = Y;
    }

    public double distance(int p, int q)
    {
        return Math.sqrt(Math.pow((p - this.x), 2) + Math.pow((q - this.y), 2));
    }

    public double distance(Punct P1)
    {
        return Math.sqrt(Math.pow((P1.x - this.x), 2) + Math.pow((P1.y - this.y), 2));
    }

    public String toString()
    {
        String SIR= "(" + this.x + ", " + this.y + ")";
        return SIR;
    }

    public static void main(String args[]){}
}
