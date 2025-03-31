package design.pizza;

import design.pizza.addons.Chicken;
import design.pizza.addons.Veggies;
import design.pizza.base.HalfandHalf;

public class Client {
    public static void main(String[] args) {
        Pizza p = new Chicken(new Veggies(new HalfandHalf()));
        Pizza p1 = new Veggies(p);
        System.out.println(p.cost());
        System.out.println(p.ingredient());
        System.out.println(p1.ingredient());
    }

}
