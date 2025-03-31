package design.grocerysys;

import java.util.List;

public class FoodItem {
    private final double basic_tax = 0.1;
    private String name;
    private List<Ingredient> ingredients;

    FoodItem(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public double calculateTotalTax() {
        double sum = 0;
        for (int i = 0; i < ingredients.size(); i++) {
            sum += ingredients.get(i).getTax();
        }
        return sum + basic_tax;
    }

}
