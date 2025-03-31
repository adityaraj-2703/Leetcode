package design.pizza.base;

import design.pizza.Pizza;

public class Full implements Pizza {
    private Pizza p;

    Full() {
    }

    Full(Pizza p) {
        // if (this.p == null) {
        // p = new Full();
        // }
        this.p = p;
    }

    @Override
    public String ingredient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ingredient'");
    }

    @Override
    public int cost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cost'");
    }

}
