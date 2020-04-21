package Problema4;

public class FoodProduct extends  Product
{
    private double calories;
    private String allergens;
    private String ingredients;
    private boolean froozen;
    private static final double value  = 1.39;

    public FoodProduct()
    {
        super();
        this.calories = 0;
        this.allergens = "";
        this.ingredients = "";
        this.froozen = false;
    }

    public FoodProduct(String n, double p, double w, String u, String exp,
                double cal, String a, String i, boolean f)
    {
        super(n, p, w, u, exp);
        this.calories = cal;
        this.allergens = a;
        this.ingredients = i;
        this.froozen = f;
    }


    public double roundPrice()
    {
        return getPrice() * value;
    }

    public void display()
    {
        System.out.println("Name of the product: " + getName());
        System.out.println("Weight: " + getWeight());
        System.out.println("This product will be expire on: " + getExpirationdate());
        System.out.println("Kcal: " + this.calories + "Allergens? " + this.allergens);
        System.out.println("Ingredients: " + this.ingredients);
        System.out.println("Froozen? " + this.froozen);
    }

    @Override
    public String toString()
    {
        return (super.toString() + "Kcal: " + this.calories + "\n" + "Allergens? " + this.allergens
                + "\n" + "Ingredients: " + this.ingredients + "\n" + "Froozen? "
                + this.froozen + "\n" + "Price: " + String.format("%.2f", roundPrice()) + "\n");
    }
}
