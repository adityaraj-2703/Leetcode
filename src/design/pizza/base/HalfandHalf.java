package design.pizza.base;

import design.pizza.Pizza;

public class HalfandHalf implements Pizza {
    private Pizza pizza;

    public HalfandHalf() {
    }

    public HalfandHalf(Pizza p) {
        // if (this.pizza == null) {
        // this.pizza = new HalfandHalf();
        // }
        this.pizza = p;
    }

    @Override
    public String ingredient() {
        // TODO Auto-generated method stub
        return "HalfAndHalf";
    }

    @Override
    public int cost() {
        // TODO Auto-generated method stub
        return 10;
    }

}
