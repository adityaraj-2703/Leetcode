package design.phonepayAfter;

public class ICICIBankAPIAdapter implements BankAPI{
    ICICIBankAPI api = new ICICIBankAPI();

    @Override
    public void pay(int payment_id, String cardNumber) {
        // TODO Auto-generated method stub
        api.payTo(123, 123, "1234");
    }

    @Override
    public boolean isSuccess(int payment_id) {
        // TODO Auto-generated method stub
        return api.checkSuccess(String.valueOf(payment_id));
    }

}
