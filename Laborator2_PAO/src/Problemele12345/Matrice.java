package Problemele12345;

public class Matrice
{
    private int n, m;
    public int[][] x;

    Matrice(int nrl, int nrc)
    {
        this.n = nrl;
        this.m = nrc;
        x = new int[n][m];
    }

    Matrice (Matrice C)
    {
        this.n = C.n;
        this.m = C.m;
        x = new int[n][m];
        x = C.x;
    }

    public Matrice add(Matrice A)
    {
        if(this.n != A.n && this.m != A.m)
            System.out.println("Nu se poate efectua calculul");

        Matrice S = new Matrice(n,m);
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j < m ; j ++)
                S.x[i][j] = this.x[i][j] + A.x[i][j];

        return S;
    }

    public Matrice multiply(Matrice P)
    {
        if(n!=P.m)
            System.out.println("Numarul de linii nu corespunde cu numarul de coloane");

        Matrice PR = new Matrice(P.n,m);
        for(int i = 0 ; i < P.n ; i ++)
            for(int j = 0 ; j < this.m ; j ++)
                for(int l = 0 ; l < P.m ; l ++)
                    PR.x[i][j] += P.x[i][l] * this.x[l][j];

        return PR;
    }

    public Matrice pow(int p)
    {
        Matrice PO = new Matrice(this);

        while(p!=1)
        {
            PO = multiply(PO);
            p --;
        }

        return PO;
    }

    public String toString()
    {
        String matrice="Numar linii: "+n+"\n"+"Numar coloane: "+m+"\n"+ "Matricea: \n";
        for(int i = 0 ; i < n ; i ++)
        {
            {
                for (int j = 0; j < m; j++)
                    matrice += this.x[i][j] + " " ;
            }
            matrice += "\n";
        }
        return matrice;
    }

    public static void main(String[] args)
    {
        Matrice A,B;
        A = new Matrice(3,3);
        B = new Matrice(3,3);

        A.x[0][0] = 1;
        A.x[0][1] = 1;
        A.x[0][2] = 1;
        A.x[1][0] = 1;
        A.x[1][1] = 1;
        A.x[1][2] = 1;
        A.x[2][0] = 1;
        A.x[2][1] = 1;
        A.x[2][2] = 1;

        B.x[0][0] = 1;
        B.x[0][1] = 1;
        B.x[0][2] = 1;
        B.x[1][0] = 2;
        B.x[1][1] = 2;
        B.x[1][2] = 2;
        B.x[2][0] = 1;
        B.x[2][1] = 1;
        B.x[2][2] = 1;

        Matrice Pr;
        Pr = A.multiply(B);
        System.out.println(Pr.toString());

        Matrice PO;
        PO = A.pow(2);
        System.out.println(PO.toString());
    }
}