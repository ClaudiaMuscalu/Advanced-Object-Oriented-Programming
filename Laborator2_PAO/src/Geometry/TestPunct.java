package Geometry;
/* nu pot accesa membrii clasei Punct deoarece sunt private */
public class TestPunct
{
    public static void main(String args[])
    {
        Punct A = new Punct(1, 3);
        Punct B = new Punct(-1, 2);

        System.out.println(A.distance(B));
    }
}
