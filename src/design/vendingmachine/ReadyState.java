package design.vendingmachine;

public class ReadyState implements VendingMachineState {

    @Override
    public void handleRequest() {
        // TODO Auto-generated method stub
        System.out.println("ready state: Please select the product");
    }

}
