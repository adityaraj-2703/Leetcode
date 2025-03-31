package design.vendingmachine;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    Map<String, Item> items;
    private PaymentStrategy paymentStrategy;
    private Dispenser dispenser;
    private Display display;
    private DisplayObserver obsever;
    private VendingMachineContext context;

    VendingMachine(DisplayObserver observer) {
        this.obsever = observer;
        this.items = new HashMap<>();
        this.dispenser = new Dispenser();
        context = new VendingMachineContext();
    }

    public void addItem(Item item) {
        this.items.put(item.getCode(), item);
    }

    public void selectItem(String itemcode) {
        this.context.setState(new ReadyState());
        this.context.request();
        Item item = items.get(itemcode);
        if (item == null) {
            obsever.update("Invalid Itemcode");
        }
        if (item.getQuantity() == 0) {
            obsever.update("Item out of stock");
        }
        obsever.update("Price:" + item.getCost());

    }

    public void insertCoin(int val) {
        this.context.setState(new ProductSelectedState());
        this.context.request();
        if (paymentStrategy instanceof CoinPaymentStrategy) {
            paymentStrategy.addPayment(val);
            obsever.update("Balance" + paymentStrategy.getBalance());
        } else {
            obsever.update("Invalid payment Strategy");
        }
    }

    public void insertCard(int val) {
        if (paymentStrategy instanceof CardPayement) {
            paymentStrategy.addPayment(val);
            obsever.update("Balance" + paymentStrategy.getBalance());
        } else {
            obsever.update("Invalid payment Strategy");
        }
    }

    public void cancelTransaction() {
        paymentStrategy.resetBalance();
        obsever.update("transaction cancelled");
    }

    public void completeTransaction(String itemcode) {
        this.context.setState(new PaymentPendingState());
        this.context.request();
        Item item = items.get(itemcode);
        if (item == null) {
            obsever.update("invalid Item code");
            return;
        }
        if (item.getQuantity() == 0) {
            obsever.update("item out of stock");
            return;
        }
        if (paymentStrategy.getBalance() < item.getCost()) {
            obsever.update("insufficient funds");
            return;
        }
        paymentStrategy.processPayment(item.getCost());
        item.setQuantity(item.getQuantity() - 1);
        items.put(itemcode, item);
        dispenser.dispense(item);
        obsever.update("Transactoin complete");
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public static void main(String[] args) {
        Display d = new Display();

        VendingMachine v = new VendingMachine(d);

        v.addItem(ItemFactory.itemFactory(Type1.SNACK, "qw", 12, 2));
        v.selectItem("qw");

        v.setPaymentStrategy(new CoinPaymentStrategy());
        v.insertCoin(1);
        v.insertCoin(5);
        v.completeTransaction("qw");

    }

}
