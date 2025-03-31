package design.grocerysys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItems(FoodItem f, int val) {
        this.items.put(f, items.getOrDefault(f, 0) + val);
    }

    public void removeItems(FoodItem f) {
        this.items.remove(f);
    }

    public Map<FoodItem, Integer> getList() {
        return this.items;
    }

}
