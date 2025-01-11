package design.phonepayAfter;

public interface BankAPI {
    void pay(int payment_id,String cardNumber);
    boolean isSuccess(int payment_id);
}
