package design.vendingmachine;

public class OutOfStockState implements VendingMachineState {

    @Override
    public void handleRequest() {
        // TODO Auto-generated method stub
        System.out.println("out of stock state: Item out of stock");
    }

}
