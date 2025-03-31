package design.parkinglot;

public interface PaymentStrategy {

    public void addBalance(int amount);

    public int getBalance();

    public void processPayment();

    public void resetBalance();

}
