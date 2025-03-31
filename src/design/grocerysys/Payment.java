package design.grocerysys;

import java.util.List;
import java.util.Map;

public class Payment {
    Cart c;

    public Payment(Cart c) {
        this.c = c;
    }

    public double calculateTotal() {
        double sum = 0;
        Map<FoodItem, Integer> f = c.getList();
        for (Map.Entry<FoodItem, Integer> f1 : f.entrySet()) {
            sum += f1.getKey().calculateTotalTax() * f1.getValue();
        }
        return sum;
    }

}
