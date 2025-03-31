package design.pizza.addons;

import design.pizza.Pizza;

public class Chicken implements Pizza {
    Pizza p;

    public Chicken(Pizza p) {

        this.p = p;
    }

    @Override
    public String ingredient() {
        // TODO Auto-generated method stub
        return this.p.ingredient() + " + chicken";
    }

    @Override
    public int cost() {
        // TODO Auto-generated method stub
        return this.p.cost() + 14;
    }

}
