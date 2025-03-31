package design.vendingmachine;

public class Display implements DisplayObserver {

    @Override
    public void update(String message) {
        // TODO Auto-generated method stub
        System.out.println("Display" + message);
    }

    public void displayPrice(int price) {
        System.out.println("Display" + price);
    }

    public void displayBalance(int balance) {
        System.out.println("Display" + balance);
    }

}
