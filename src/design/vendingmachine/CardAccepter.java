package design.vendingmachine;

public class CardAccepter {
    public void acceptCard(int cost, PaymentStrategy p) {
        p.addPayment(cost);
    }

}
