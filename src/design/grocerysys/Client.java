package design.grocerysys;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        Ingredient sugar = new Ingredient("Sugar", 0.2);
        Ingredient biscuit = new Ingredient("Biscuit", 0.5);
        Ingredient salt = new Ingredient("salt", 0.4);
        Ingredient spices = new Ingredient("spices", 0.7);
        FoodItem f = new FoodItem("Cake", Arrays.asList(sugar, biscuit));
        Cart c = new Cart();
        c.addItems(f, 2);
        Payment p = new Payment(c);
        System.out.println(p.calculateTotal());
        FoodItem f1 = new FoodItem("Kurkure", Arrays.asList(salt, spices));
        c.addItems(f1, 3);
        System.out.println(p.calculateTotal());

    }
}
