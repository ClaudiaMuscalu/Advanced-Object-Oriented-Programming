package Problema3;

public class Circle
{
    private double radius;
    private String colour;

    public Circle()
    {
        this.radius = 1.0;
        this.colour = "red";
    }

    public Circle(double R, String C)
    {
        this.radius = R;
        this.colour = C;
    }

    public void setRadius(double x)
    {
        this.radius = x;
    }

    public void setColour(String y)
    {
        this.colour = y;
    }

    public double getRadius()
    { return this.radius;
    }

    public String getColour()
    {
        return this.colour;
    }

    public double getArea()
    {
        return (2 * Math.PI * this.radius * this.radius);
    }

    @Override
    public String toString()
    {
        return "Radius: " + this.radius + "; Colour:" + this.colour;
    }

    @Override
    public boolean equals(Object obj)
    {
        // If the object is compared with itself then return true
        if (this == obj)
            return true;

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if(obj == null || obj.getClass() != getClass())
            return false;

        /* typecast to Circle */
        Circle c = (Circle) obj;
        return Double.compare(radius, c.radius) == 0
                && colour.equals(c.colour) == true;
    }

    public static void main(String args[]){}
}
