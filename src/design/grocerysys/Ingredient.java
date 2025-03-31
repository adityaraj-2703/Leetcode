package design.grocerysys;

public class Ingredient {
    private String name;
    private double tax;

    public Ingredient(String name, double tax) {
        this.name = name;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public double getTax() {
        return tax;
    }

}
