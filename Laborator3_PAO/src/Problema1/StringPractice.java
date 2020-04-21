package Problema1;

public class StringPractice
{
    static final int ASCII_SIZE = 256;
    public static void ex1()
    {
        /* The indexOf() method returns the position
        of the first occurrence of specified character(s) in a string.*/
        String myStr = "Hello planet earth, you are a great planet.";
        System.out.println(myStr.indexOf("planet"));

        /* Use the lastIndexOf method to return the position of
        the last occurrence of specified character(s) in a string.*/
        System.out.println(myStr.lastIndexOf("planet"));

        /* The length() method returns the length of a specified string.
        Note: The length of an empty string is 0.*/
        System.out.println("Lungimea sirului: " + myStr + " este");
        System.out.println(myStr.length());

        /* Splits a string into an array of substrings */
        String[] arrofStr = myStr.split(" ",9);
        for(String a : arrofStr)
            System.out.println(a);
    }

    public static char ex2(String sir)
    {
        /* charAt()	Returns the character at the specified index (position)*/
        int count[] = new int[ASCII_SIZE];
        int l = sir.length();
        for(int i = 0 ; i < l ; i ++)
            count[sir.charAt(i)] ++;

        int max = -1;
        char result = ' ';

        for(int i = 0 ; i < l ; i++)
        {
            if (max < count[sir.charAt(i)])
            {
                max = count[sir.charAt(i)];
                result = sir.charAt(i);
            }
        }
        return result;
    }

    public static void  ex3()
    {
        /* The replace() method searches a string for a specified character,
         and returns a new string where the specified character(s) are replaced.
         */
        String sir = "ananas, amic, acuarela";
        System.out.println(sir.replace('a','*'));
    }

    public static void ex4()
    {
        /* Remove whitespace from both sides of a string:*/
        String sir = "        Am o gramada pe spatii albe in textul acesta!     ";
        System.out.println(sir.trim());
    }

    public static String ex5(String s1, String s2)
    {
        int l2 = s2.length();
        String a = s1.substring(0, 3);
        String b = s2.substring(l2 - 3, l2);

        if(a.equals(b))
           return s1.concat(s2);;
        return s2.concat(s1);
    }

    public static void main(String args[])
    {
        System.out.println("Exercitiul 1:");
        ex1();

        String sir = "Constantinopol" ;
        System.out.println("Exercitiul 2:");
        System.out.println("Litera cea mai frecventa este: " + ex2(sir));

        System.out.println("Exercitiul 3:");
        ex3();

        System.out.println("Exercitiul 4:");
        ex4();

        System.out.println("Exercitiul 5:");
        String s1 = "ele fac";
        String s2 = "cafele";
        System.out.println(ex5(s1, s2));
    }
}
