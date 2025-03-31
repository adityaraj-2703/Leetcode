package design.vendingmachine;

public class Item {
    private Type1 type;
    private int cost;
    private String code;
    private int quantity;

    Item(String code, int cost, int quantity) {
        this.code = code;
        this.cost = cost;
        this.quantity = quantity;
    }

    public Type1 getType() {
        return type;
    }

    public void setType(Type1 type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
