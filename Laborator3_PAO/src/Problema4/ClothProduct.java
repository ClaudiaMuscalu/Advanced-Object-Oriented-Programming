package Problema4;

public class ClothProduct extends Product
{
    private String textile;
    private String size;
    private String handmade;
    private static final double value  = 9.89;

    public ClothProduct()
    {
        super();
        this.textile = "";
        this.size = "";
        this.handmade = "";
    }

    public ClothProduct(String n, double p, double w, String u,
                        String exp, String t, String s, String h)
    {
        super(n, p, w, u, exp);
        this.textile = t;
        this.size = s;
        this.handmade = h;
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
        System.out.println("Textile: " + this.textile);
        System.out.println("Size: " + this.size);
        System.out.println("Handmade? " + this.handmade);
    }
    @Override
    public String toString()
    {
        return (super.toString() + "Textile: " + this.textile
                + "Size: " + this.size + "\n" + "Handmade? " + this.handmade
                + "\n" + "Price: " + String.format("%.2f", roundPrice()) + "\n");
    }
}
