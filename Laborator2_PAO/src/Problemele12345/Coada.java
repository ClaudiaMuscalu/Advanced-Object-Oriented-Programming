package Problemele12345;
import java.util.Arrays;

public class Coada
{
    private int size;
    private int capacity;
    private int[] v;

    public Coada()
    {
        capacity = 100;
    }

    public Coada(int s)
    {
        this.capacity = s;
        this.v = new int[capacity];
    }

    public boolean isEmpty()
    {
        if (size != 0)
            return false;
        return true;
    }

    public void push(int x)
    {
        if (size == capacity)
            System.out.println("S-a depasit dimensiunea alocata!");
        else {
            v[size] = x;
            size ++;
        }
    }

    public void pop()
    {
        if (size == 0)
            System.out.println("Coada este deja vida!");
        else {
            int y = v[0];
            for (int i = 1; i < size; i ++)
                v[i - 1] = v[i];
            size--;
        }
    }

    public String toString()
    {
        String afis = "";
        afis += String.valueOf(size) + " ";

        for (int i = 0; i < size; i ++)
            afis += String.valueOf(v[i]) + " ";

        return afis;
    }

   public static void main(String args[])
    {
        Coada C = new Coada(50);

        if(C.isEmpty())
            System.out.println("Coada este vida!");
        else
            System.out.println("Coada nu este vida!");

        C.push(9);
        C.push(10);
        C.push(11);
        C.push(12);
        C.push(13);
        C.push(14);

        System.out.println(C.toString());

        C.pop();
        C.pop();

        System.out.println(C.toString());

        if(C.isEmpty())
            System.out.println("Coada este vida!");
        else
            System.out.println("Coada nu este vida!");
    }
}
