package design.vendingmachine;

public class CoinAccepter {
    public void acceptCoin(int coin, PaymentStrategy p) {
        p.addPayment(coin);
    }

}
