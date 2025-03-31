package design.vendingmachine;

public class ItemFactory {
    public static Item itemFactory(Type1 type, String code, int cost, int quantity) {
        if (type.equals(Type1.SNACK)) {
            return new SnackItem(code, cost, quantity);
        } else if (type.equals(Type1.DRINKS)) {
            return new DrinkItem(code, cost, quantity);
        } else {
            return null;
        }
    }

}
