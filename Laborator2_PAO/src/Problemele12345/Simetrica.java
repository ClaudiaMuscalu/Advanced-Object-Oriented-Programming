package Problemele12345;

public class Simetrica
{
    private int n;
    public int [][] M;

    Simetrica(int x)
    {
        this.n = x;
        M = new int[n][n];
    }

    boolean Simetrica()
    {
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                if (M[i][j] != M[j][i])
                    return false;
                return true;
    }

    public String toString()
    {
        if (Simetrica())
            return ("Matricea este simetrica");
        return ("Matricea nu este simetrica");
    }

    public static void main(String[] args)
    {
        // exemplu matrice simetrica
        Simetrica A = new Simetrica(3);
        A.M[0][0] = 1;
        A.M[0][1] = 7;
        A.M[0][2] = 3;
        A.M[1][0] = 7;
        A.M[1][1] = 4;
        A.M[1][2] = -5;
        A.M[2][0] = 3;
        A.M[2][1] = -5;
        A.M[2][2] = 6;

        System.out.println(A.toString());

        // exemplu matrice ce nu este simetrica
        Simetrica B = new Simetrica(3);
        B.M[0][0] = 2;
        B.M[0][1] = 72;
        B.M[0][2] = 9;
        B.M[1][0] = 7;
        B.M[1][1] = 4;
        B.M[1][2] = -5;
        B.M[2][0] = 3;
        B.M[2][1] = -5;
        B.M[2][2] = 6;

        System.out.println(B.toString());
    }
}