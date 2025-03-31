package design.vendingmachine;

public class Dispenser {
    public void dispense(Item item) {
        System.out.println("Dispensing Item:" + item.getCode());
    }
}
