package design.vendingmachine;

public interface PaymentStrategy {
    void addPayment(int amount);

    int getBalance();

    void resetBalance();

    void processPayment(int amount);

}
