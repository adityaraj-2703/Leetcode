package design.phonepayAfter;

public class YesBankAPIAdapter implements BankAPI{
    YesBankAPI api = new YesBankAPI();

    @Override
    public void pay(int payment_id, String cardNumber) {
        // TODO Auto-generated method stub
        api.makePayments(payment_id, cardNumber, payment_id);
    }

    @Override
    public boolean isSuccess(int payment_id) {
        // TODO Auto-generated method stub
        return api.checkSuccess(payment_id);
    }

}
