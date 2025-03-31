package design.vendingmachine;

public class CardPayement implements PaymentStrategy {
    int balance = 0;

    @Override
    public void addPayment(int amount) {
        // TODO Auto-generated method stub
        this.balance += amount;
    }

    @Override
    public int getBalance() {
        // TODO Auto-generated method stub
        return this.balance;
    }

    @Override
    public void resetBalance() {
        // TODO Auto-generated method stub
        this.balance = 0;
    }

    @Override
    public void processPayment(int amount) {
        // TODO Auto-generated method stub
        this.balance -= amount;
    }

}
