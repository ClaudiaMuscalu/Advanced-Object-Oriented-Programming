package Problema4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String args[])
    {
        CleaningProduct cleaningProduct = new CleaningProduct("Sanytol", 13.5, 1000,
                                " ml", "12/07/2020", "disinfection", false);
        System.out.println(cleaningProduct.toString());

        FoodProduct foodP = new FoodProduct("Butter", 4.5, 100, " g", "13/09/2020", 101.8, "no",
                             "components of milk or cream", false );
        System.out.println(foodP.toString());

        ClothProduct clothP = new ClothProduct("Shirt", 4.7, 356, " g", "-", "bumbac", "M", "yes" );
        System.out.println(clothP.toString());

        FurnitureProduct furnitureProduct = new FurnitureProduct("Table", 7.78, 3, " kg", "-", "wood",  2);
        System.out.println(furnitureProduct.toString());

        ArrayList<Product> Products = new ArrayList<>();
        Products.add(cleaningProduct);
        Products.add(foodP);
        Products.add(clothP);
        Products.add(furnitureProduct);

        System.out.println(Products.get(0).toString());

    }
}
