package Problema4;

public class FurnitureProduct extends Product
{
    private String material;
    private int guarantee;
    private static final double value  = 100.67;

    public FurnitureProduct()
    {
        super();
        this.material = "";
        this.guarantee = 0;
    }

    public FurnitureProduct(String n, double p, double w,
                            String u, String exp, String m, int g)
    {
        super(n, p, w, u, exp);
        this.material = m;
        this.guarantee = g;
    }

    @Override
    public double roundPrice()
    {
        return getPrice() * value;
    }

    public void display()
    {
        System.out.println("Name of the product: " + getName());
        System.out.println("Weight: " + getWeight());
        System.out.println("This product will be expire on: " + getExpirationdate());
        System.out.println("Material: " + this.material);
        System.out.println("Guarantee: " + this.guarantee);
    }

    @Override
    public String toString()
    {
        return (super.toString() + "Material: " + this.material
                + "\n" + "Guarantee: " + this.guarantee + "\n"
                + "Price: " + String.format("%.2f", roundPrice()) + "\n");
    }
}
