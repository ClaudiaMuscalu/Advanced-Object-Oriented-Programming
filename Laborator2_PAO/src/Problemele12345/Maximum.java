package Problemele12345;

public class Maximum
{
    int x;
    public Maximum()
    {
        this.x = 0;
    }
    public Maximum(int y)
    {
        this.x = y;
    }

    public int maxim(int a)
    {
        if(a > x)
            return a;
        return x;

    }

    public int maxim(int a, int b)
    {
        int y = x;
        int p = maxim(a);
        int s = maxim(b);
        x = y;
        return s;
    }

    public int maxim(int a, int b, int c)
    {
        return maxim(maxim(a, b), maxim(c));
    }

    public int maxim(int a, int b, int c, int d)
    {
        return maxim(maxim(a, b), maxim(d, c));
    }

    public static void main(String args[])
    {
        Maximum nr = new Maximum(2);
        System.out.println(nr.maxim(3));
        System.out.println(nr.maxim(3,6));
        System.out.println(nr.maxim(4,6,9));
        System.out.println(nr.maxim(4,1,7,2));
    }
}