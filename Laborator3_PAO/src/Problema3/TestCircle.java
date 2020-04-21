package Problema3;
import java.util.ArrayList;

public class TestCircle
{
    private ArrayList<Circle> ArrayCircle = new ArrayList<>();

    public TestCircle()
    {
        Circle c1 = new Circle();
        Circle c2 = new Circle(7.8, "red");
        Circle c3 = new Circle(7.8, "red");
        Circle c4 = new Circle(7.8, "blue");

        System.out.println("c2 = c3 ? is " + c2.equals(c3));
        System.out.println("c2 = c4 ? is " + c2.equals(c4));

        ArrayCircle.add(c1);
        ArrayCircle.add(c2);
        ArrayCircle.add(c3);
        ArrayCircle.add(c4);
    }

    public ArrayList<Circle> getCircles()
    {
        return ArrayCircle;
    }

    public static void main(String args[])
    {
        TestCircle Circles = new TestCircle();

        System.out.println("Print the radius and the colour:");
        for(int i = 0 ; i < Circles.getCircles().size() ; i ++)
            System.out.println(Circles.getCircles().get(i).getRadius() + " "
                    + Circles.getCircles().get(i).getColour());

        System.out.println("Testing set for modify the colour:");
        System.out.println("Before set: " + Circles.getCircles().get(0).getColour());
        Circles.getCircles().get(0).setColour("yellow");
        System.out.println("After set: " + Circles.getCircles().get(0).getColour());

        System.out.println("Print areas:");
        for(int i = 0 ; i < Circles.getCircles().size() ; i ++)
            System.out.println(String.format("%.2f",Circles.getCircles().get(i).getArea()));
    }
}
