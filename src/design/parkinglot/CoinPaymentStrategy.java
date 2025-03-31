package design.parkinglot;

public class CoinPaymentStrategy implements PaymentStrategy {

    private int balance;

    @Override
    public void addBalance(int amount) {
        // TODO Auto-generated method stub
        this.balance += amount;
    }

    @Override
    public int getBalance() {
        // TODO Auto-generated method stub
        return this.balance;
    }

    @Override
    public void processPayment() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resetBalance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetBalance'");
    }

}
