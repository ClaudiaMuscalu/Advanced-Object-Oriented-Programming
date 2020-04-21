package Problema4;

import java.text.DecimalFormat;

public class CleaningProduct extends Product
{
    private String category;
    private boolean chemical;
    private static final double value  = 2.31;

    public CleaningProduct()
    {
        super();
        this.category = "";
        this.chemical = false;
    }

    public CleaningProduct(String n, double p, double w,
                    String u, String exp, String c, boolean b)
    {
        super(n, p, w, u, exp);
        this.category = c;
        this.chemical = b;
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
        System.out.println("Category is: " + this.category);
        System.out.println("Contains it chemical products? " + this.chemical);
    }

    @Override
    public String toString()
    {
        return (super.toString() + "Category is: " + this.category + "\n"
                + "Contains it chemical products? " + this.chemical + "\n"
                + "Price: " + String.format("%.2f", roundPrice()) + "\n");
    }
}
