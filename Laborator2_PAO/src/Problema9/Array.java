package Problema9;

import java.util.Arrays;

public class Array
{
    /*private int size;
    private int []arr;

    public Array(int S, int v[])
    {
        this.size = S;
        arr = new int[size];
        for(int i = 0 ; i < size ; i ++)
            arr[i] = v[i];
    }*/

    public  static int[] cauta(int [] arr, int item)
    {
        int poz = -1;
        for(int i = 0 ; i < arr.length && poz == -1 ; i ++)
            if(arr[i] == item)
                poz = i;

         if(poz == -1)
             return null;
         return  Arrays.copyOfRange(arr, poz, arr.length);
    }

    /*public String toString()
    {
        String afis = "Array: ";
        for(int i = 0 ; i < size ; i ++)
            afis += arr[i] + " ";

        afis += "\n";
        return afis;
    }*/
    public static void main(String args[])
    {
        int arr[] = {1, 5, 6, 9, 12, 22, 7, 20};
        int item = 9;

        int result[] = cauta(arr, item);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result));
    }
}
