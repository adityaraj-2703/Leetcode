package design.pizza.addons;

import design.pizza.Pizza;

public class Veggies implements Pizza {
    Pizza p;

    public Veggies(Pizza p) {
        this.p = p;
    }

    @Override
    public String ingredient() {
        // TODO Auto-generated method stub
        if (this.p == null) {
            throw new IllegalArgumentException();
        }
        return this.p.ingredient() + " + Veggies";
    }

    @Override
    public int cost() {
        // TODO Auto-generated method stub
        if (this.p == null) {
            throw new IllegalArgumentException();
        }
        return this.p.cost() + 10;
    }

}
