package design.carrentalsystem.payment;

public interface PaymentProcessor {
    boolean processPayment(double amount);
}
