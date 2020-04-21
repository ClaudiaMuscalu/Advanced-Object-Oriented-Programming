package Problema4;

public abstract class Product
{
    private String name;
    private double price;
    private double weight;
    private String unit;
    private String expirationdate;

    public Product()
    {
        this.name = "";
        this.price = 0.0;
        this.weight = 0.0;
        this.unit = "";
        this.expirationdate = "";
    }

    public Product(String n, double p, double w, String u, String exp)
    {
        this.name = n;
        this.price = p;
        this.weight = w;
        this.unit = u;
        this.expirationdate = exp;

    }

    public abstract double roundPrice();

    public abstract void display();

    public double getPrice()
    {
        return price;
    }

    public String getExpirationdate()
    {
        return expirationdate;
    }

    public String getName()
    {
        return this.name;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public String getUnit()
    {
        return this.unit;
    }

    public String toString()
    {
        String print = "Name of the product: " + getName() + "\n";
        print += "Weight: " + getWeight() + getUnit() + "\n";
        print += "This product will be expire on: " + getExpirationdate() + "\n";
        return print;
    }
}
