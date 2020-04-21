package Problema2;
public class Main
{
    /**
     * String class:
     *
     *  String Class in Java creates an immutable sequence of characters
     *  Immutable class means that once an object is created, we cannot change its content;
     *  Immutable classes are helpful because you know they will always be the same;
     *  You can pass them around your application with a guarantee that the caller didn’t change
     * anything;
     * Immutable classes are thread safe
     */
    public static void StringExamples()
    {
        String sir = "Laboratorul de saptamana aceasta este despre clasa String!";
        System.out.println(sir);

        char[] ch = {'S', 't', 'r', 'i', 'n', 'g'};
        String s = new String(ch);
        System.out.println(s);

        char char_arr[] = {'s', 't', 'r', 'i', 'n', 'g'};
        String s1 = new String(char_arr , 0, 3); //str
        System.out.println(s1);

        System.out.println("PAO".length());
        System.out.println("Buna".charAt(2));
        System.out.println("tractor".substring(2));
        System.out.println("Apus de soare".substring(1,8));
        System.out.println("Buna".concat(" seara!"));

        /* Returns the index within the string of the first occurrence of the specified string.*/
        String str = "Nu ma asteptam la o asa proba!";
        System.out.println(str.indexOf("as"));//6

        /* int indexOf (String s, int i): Returns the index within the string of the
        first occurrence of the specified string, starting at the specified index.*/
        System.out.println(str.indexOf("as",7));

        String ss = "Learn Share Learn";
        int output = ss.lastIndexOf("a");
        System.out.println(output);

        Boolean out1 = "Pao".equals("pao");
        Boolean out2 = "PAO".equals("PAO");
        System.out.println(out1);
        System.out.println(out2);

        /* boolean  equalsIgnoreCase (String anotherString):
        Compares string to another string, ignoring case considerations.*/
        Boolean out3 = "Pao".equalsIgnoreCase("pao");
        System.out.println(out3);

        String pr = sir.toUpperCase();
        System.out.println(pr);

        String word = "helLO";
        System.out.println(word.toLowerCase());
    }

    public static void StringBufferExamples()
    {
        StringBuffer s = new StringBuffer("LaboratorPAO");
        int p = s.length();
        int q = s.capacity();
        System.out.println("Length of string = "+ p);
        System.out.println("Capacity of string=" + q);// =p+16

        /* It is used to add text at the end of the existence text.*/
        s.append(" nr.3");
        System.out.println(s);

       /*It is used to insert text at the specified index position*/
        s.insert(9,"ul la cursul de ");
        System.out.println(s);

        /* It can reverse the characters within a StringBuffer object using reverse( )*/
        StringBuffer strr = new StringBuffer("ucenic");
        strr.reverse();
        System.out.println(strr);

        s.delete(3,9);
        System.out.println(s);

        s.deleteCharAt(3);
        s.deleteCharAt(3);
        System.out.println(s);
    }

    public static void StringBuilderExamples()
    {
        StringBuilder s1 = new StringBuilder();
        System.out.println(s1.capacity());

        StringBuilder str1 = new StringBuilder("AAAABBBCCCC");

        System.out.println("String1 = " + str1.toString());
        System.out.println(str1.capacity());
        System.out.println(str1.length());

        StringBuilder reverseStr = str1.reverse();
        System.out.println("String1 reverse = " + str1.toString());

        str1.append("DDD");
        System.out.println(str1.toString());

        /* This method accepts only one parameter codePoint which is
        int type value refers to a Unicode code point.
         */
        str1.appendCodePoint(69);
        System.out.println(str1.toString());
    }

    public static void main(String args[])
    {
        System.out.println("String class examples:\n");
        StringExamples();

        System.out.println("StringBuffer class examples:\n");
        StringBufferExamples();

        System.out.println("StringBuilder class examples:\n");
        StringBuilderExamples();
    }
}
